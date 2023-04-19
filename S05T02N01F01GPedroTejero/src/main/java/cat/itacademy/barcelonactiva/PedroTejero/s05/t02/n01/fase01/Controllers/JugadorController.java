package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.dto.JugadaDTO;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.dto.JugadorDTO;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.dto.JugadorMapper;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.services.JugadaServiceImpl;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.services.JugadorServiceImpl;

@Controller
@RequestMapping("/Players")
public class JugadorController {
	
	@Autowired
	JugadorServiceImpl jugadorservice;
	JugadaServiceImpl jugadaservice;
	
	@GetMapping
	public String crearJugador (Model model) {
		Jugador jugador= new Jugador();
		model.addAttribute("jugador", jugador);
		return"nuevo_jugador";
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
				model.addAttribute("jugadas", jugadordto.getJugadas());
				return "jugador";
			} else
				return "jugador_no_encontrado";
		} catch (Exception e) {
			return "error";
		}
	
	/*@PostMapping("/{jugador_id}/games")
	public String pantallaJugada(@PathVariable(value = "jugador_id") int jugador_id, Model model) {
		try {
				JugadaDTO jugadadto= new JugadaDTO(jugador_id);
				model.addAttribute("jugadadto", jugadadto);
				jugadaservice.guardarJugada(jugadadto);
				return"resultado";

		} catch (Exception e) {
			return "error";
		}*/
	}
	@PostMapping("/{jugador_id}/games/resultado")
	public String pantallaJugada(@PathVariable(value = "jugador_id") int jugador_id, Model model) {
		try {
				JugadaDTO jugadadto= new JugadaDTO(jugador_id);
				model.addAttribute("jugadadto", jugadadto);
				jugadaservice.guardarJugada(jugadadto);
				return"jugadorjugada";

		} catch (Exception e) {
			return "error";
		}
	}
	

	

}
