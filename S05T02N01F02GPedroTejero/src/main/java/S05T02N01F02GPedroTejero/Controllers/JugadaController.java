package S05T02N01F02GPedroTejero.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import S05T02N01F02GPedroTejero.model.dto.JugadaDTO;
import S05T02N01F02GPedroTejero.model.services.JugadaServiceImpl;
import S05T02N01F02GPedroTejero.model.services.JugadorServiceImpl;

@Controller
@RequestMapping("/Players")
public class JugadaController {

	@Autowired
	JugadorServiceImpl jugadorservice;
	@Autowired
	JugadaServiceImpl jugadaservice;

	@GetMapping("/{jugador_id}/delete")
	public String borrarListaJugadas(@PathVariable(value = "jugador_id") String jugador_id) {
		try {
			jugadaservice.eliminarJugadas(jugador_id);

		} catch (Exception e) {
			return "error";
		}
		return "exito";
	}

	@GetMapping("/{jugador_id}/jugada")
	public String pantallaJugada(@PathVariable("jugador_id") String id, @ModelAttribute("jugada") JugadaDTO jugadadto,
			Model model) {
		return "jugada";
	}
}
