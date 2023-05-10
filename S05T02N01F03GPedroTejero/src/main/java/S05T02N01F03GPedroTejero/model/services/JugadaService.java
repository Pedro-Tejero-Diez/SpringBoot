package S05T02N01F03GPedroTejero.model.services;

import java.util.List;

import S05T02N01F03GPedroTejero.model.domain.Jugada;
import S05T02N01F03GPedroTejero.model.dto.JugadaDTO;

public interface JugadaService {

	List<Jugada> getAllJugada();

	void guardarJugada(JugadaDTO jugadadto);

	List<Jugada> getAllJugadabyJugador(String jugador_id);

	void eliminarJugadas(String id);

}
