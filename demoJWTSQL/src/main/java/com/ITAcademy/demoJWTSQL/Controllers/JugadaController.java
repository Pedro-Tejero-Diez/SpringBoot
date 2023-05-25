package com.ITAcademy.demoJWTSQL.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ITAcademy.demoJWTSQL.domain.dto.JugadaDTO;
import com.ITAcademy.demoJWTSQL.domain.services.JugadaServiceImpl;
import com.ITAcademy.demoJWTSQL.domain.services.JugadorServiceImpl;

@Controller
@RequestMapping("/Players")
public class JugadaController {

	@Autowired
	JugadorServiceImpl jugadorservice;
	@Autowired
	JugadaServiceImpl jugadaservice;

	@GetMapping("/{jugador_id}/delete")
	public String borrarListaJugadas(@PathVariable(value = "jugador_id") int id) {
		try {
			jugadaservice.eliminarJugadas(id);

		} catch (Exception e) {
			return "error";
		}
		return "exito";
	}

	@GetMapping("/{jugador_id}/jugada")
	public String pantallaJugada(@PathVariable("jugador_id") int id, @ModelAttribute("jugada") JugadaDTO jugadadto,
			Model model) {
		return "jugada";
	}
}
