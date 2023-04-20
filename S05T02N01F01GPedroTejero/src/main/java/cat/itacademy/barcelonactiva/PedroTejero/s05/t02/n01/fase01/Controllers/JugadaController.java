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
public class JugadaController {
	
	@Autowired
	JugadorServiceImpl jugadorservice;
	JugadaServiceImpl jugadaservice;
	
	/*@PostMapping("/{jugador_id}/games")
	public String pantallaJugada(@ModelAttribute ("jugador_id") int jugador_id, Model model) {
		try {
				JugadaDTO jugadadto= new JugadaDTO(jugador_id);
				model.addAttribute("jugadadto", jugadadto);
				jugadaservice.guardarJugada(jugadadto);
				return"resultado";

		} catch (Exception e) {
			return "error";
		}
	}
}*/
	
	/*@GetMapping("/resultado")
	public String pantallaJugada(Model model) {

			SucursalDTO sucursaldto = new SucursalDTO();
			model.addAttribute("sucursaldto", sucursaldto);
			return "new_Sucursal";*/
	
	/*@PostMapping("/games/jugada")
	public String pantallaJugada(@ModelAttribute ("jugador:id") int jugador_id, Model model) {
		try {
				JugadaDTO jugadadto= new JugadaDTO(jugador_id);
				model.addAttribute("jugadadto", jugadadto);
				jugadaservice.guardarJugada(jugadadto);
				return"resultado";

		} catch (Exception e) {
			return "error";
		}
	}
}*/
	/*PUT /players: modifica el nom del jugador/a.
	POST /players/{id}/games/ : un jugador/a específic realitza una tirada dels daus.  
	DELETE /players/{id}/games: elimina les tirades del jugador/a.
	GET /players/: retorna el llistat de tots  els jugadors/es del sistema amb el seu  percentatge mitjà d’èxits.   
	GET /players/{id}/games: retorna el llistat de jugades per un jugador/a.  
	GET /players/ranking: retorna el ranking mig de tots els jugadors/es del sistema. És a dir, el  percentatge mitjà d’èxits. 
	GET /players/ranking/loser: retorna el jugador/a  amb pitjor percentatge d’èxit.  
	GET /players/ranking/winner: retorna el  jugador amb pitjor percentatge d’èxit. 
*/
}
