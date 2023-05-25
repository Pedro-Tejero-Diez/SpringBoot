package com.ITAcademy.demoJWTSQL.Controllers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ITAcademy.demoJWTSQL.domain.services.JugadaServiceImpl;
import com.ITAcademy.demoJWTSQL.domain.services.JugadorServiceImpl;
import com.ITAcademy.demoJWTSQL.domain.dto.JugadorDTO;
import com.ITAcademy.demoJWTSQL.domain.dto.JugadaDTO;
import com.ITAcademy.demoJWTSQL.domain.dto.JugadaMapper;
import com.ITAcademy.demoJWTSQL.domain.dto.JugadorMapper;
import com.ITAcademy.demoJWTSQL.domain.models.Jugador;


@Controller
@RequestMapping("/Players")
public class JugadorController {

	@Autowired
	JugadorServiceImpl jugadorservice;
	@Autowired
	JugadaServiceImpl jugadaservice;

	@GetMapping
	public String crearJugador(Model model) {
		Jugador jugador = new Jugador();
		model.addAttribute("jugador", jugador);
		return "nuevo_jugador";
	}

	@GetMapping("/")
	public String jugadores(Model model) {
		List<Jugador> jugadores = jugadorservice.getAllJugador();
		model.addAttribute("jugadores",
				jugadores.stream().map(JugadorMapper::toJugadorDTO).collect(Collectors.toList()));
		return "listado_jugadores";
	}

	@PostMapping("/add")
	public String guardarJugador(@ModelAttribute("jugador") Jugador jugador) {
		try {
			jugadorservice.guardarJugador(jugador);

			return "exito";

		} catch (Exception e) {
			return "error";
		}
	}

	@GetMapping("/{jugador_id}/games")
	public String pantallaJugador(@PathVariable(value = "jugador_id") int jugador_id, Model model) {

		try {
			Jugador jugador = jugadorservice.getJugadorbyId(jugador_id);
			if (jugador != null) {
				JugadorDTO jugadordto = JugadorMapper.toJugadorDTO(jugador);
				model.addAttribute("jugadas",
						jugadordto.getJugadas().stream().map(JugadaMapper::toJugadaDTO).collect(Collectors.toList()));
				model.addAttribute("jugador", jugadordto);
				return "jugador";
			} else
				return "jugador_no_encontrado";
		} catch (Exception e) {
			return "error";
		}
	}

	@PostMapping("/{jugador_id}/games")
	public String pantallaJugada(@PathVariable(value = "jugador_id") int jugador_id, RedirectAttributes ra,
			Model model) {
		try {
			JugadaDTO jugadadto = new JugadaDTO(jugador_id);
			jugadaservice.guardarJugada(jugadadto);
			ra.addFlashAttribute("jugada", jugadadto);
			return "redirect:/Players/{jugador_id}/jugada";

		} catch (Exception e) {
			return "error";
		}
	}

	@GetMapping("/Ranking")
	public String mostrarRanking(Model model) {
		List<Jugador> jugadores = jugadorservice.getAllJugador();
		model.addAttribute("jugadores",
				jugadores.stream().map(JugadorMapper::toJugadorDTO).collect(Collectors.toList()));
		return "Ranking";
	}

	@GetMapping("/Ranking/loser")
	public String mostrarPerdedor(Model model) {
		List<JugadorDTO> jugadores = jugadorservice.getAllJugador().stream().map(JugadorMapper::toJugadorDTO)
				.collect(Collectors.toList());
		String nombrePerdedor = jugadores.stream().min(Comparator.comparing(JugadorDTO::getExito)).get().getNombre();
		model.addAttribute("nombrep", nombrePerdedor);
		return "loser";
	}

	@GetMapping("/Ranking/winner")
	public String mostrarGanador(Model model) {
		List<JugadorDTO> jugadores = jugadorservice.getAllJugador().stream().map(JugadorMapper::toJugadorDTO)
				.collect(Collectors.toList());
		String nombreGanador = jugadores.stream().max(Comparator.comparing(JugadorDTO::getExito)).get().getNombre();
		model.addAttribute("nombreg", nombreGanador);
		return "winner";
	}

	@GetMapping("/{jugador_id}/getOne")
	public String getOneJugador(@PathVariable(value = "jugador_id") int jugador_id, Model model) {

		try {
			Jugador jugador = jugadorservice.getJugadorbyId(jugador_id);
			if (jugador != null) {
				JugadorDTO jugadordto = JugadorMapper.toJugadorDTO(jugador);
				model.addAttribute("jugadordto", jugadordto);

				return "showone";
			} else
				return "jugador_no_encontrado";
		} catch (Exception e) {
			return "error";
		}
	}

	@PostMapping("/update")
	public String actualizarJugador(@ModelAttribute("jugadordto") JugadorDTO jugadordto) {
		try {
			jugadorservice.updateJugador(jugadordto.getJugador_id(), jugadordto);
			return "exito";

		} catch (Exception e) {
			return "error";
		}
	}

	@GetMapping("/{jugador_id}/deleteListado")
	public String eliminarListas(@PathVariable(value = "jugador_id") int jugador_id, RedirectAttributes ra,
			Model model) {
		try {
			Jugador jugador = jugadorservice.getJugadorbyId(jugador_id);
			ra.addFlashAttribute("jugador", jugador);
			return "redirect:/Players/{jugador_id}/delete";

		} catch (Exception e) {
			return "error";
		}
	}
}
