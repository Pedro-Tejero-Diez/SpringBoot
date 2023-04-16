package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugada;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.dto.JugadaDTO;

public interface JugadaService {
	
	List<Jugada> getAllJugada();

	void guardarJugada(JugadaDTO jugadadto);
	
	List<Jugada> getAllJugadabyJugador(int jugador_id);

	Jugada getJugadabyId(int jugada_id);


	

}
