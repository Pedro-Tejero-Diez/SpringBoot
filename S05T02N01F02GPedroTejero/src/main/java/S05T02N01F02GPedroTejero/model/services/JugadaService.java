package S05T02N01F02GPedroTejero.model.services;

import java.util.List;

import S05T02N01F02GPedroTejero.model.domain.Jugada;
import S05T02N01F02GPedroTejero.model.dto.JugadaDTO;


public interface JugadaService {
	
	List<Jugada> getAllJugada();

	void guardarJugada(JugadaDTO jugadadto);

	List<Jugada> getAllJugadabyJugador(int jugador_id);

	Jugada getJugadabyId(int jugada_id);

	void eliminarJugadas(String id);

}

