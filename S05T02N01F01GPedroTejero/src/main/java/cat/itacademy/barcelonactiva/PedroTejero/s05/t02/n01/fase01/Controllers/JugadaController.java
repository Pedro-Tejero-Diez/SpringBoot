package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Players")
public class JugadaController {
	
	 
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
