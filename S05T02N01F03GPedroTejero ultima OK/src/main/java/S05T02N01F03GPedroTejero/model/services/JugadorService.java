package S05T02N01F03GPedroTejero.model.services;

import java.util.List;

import S05T02N01F03GPedroTejero.model.domain.Jugador;
import S05T02N01F03GPedroTejero.model.dto.JugadorDTO;

public interface JugadorService {

	List<Jugador> getAllJugador();

	Jugador getJugadorbyId(String jugador_id);

	void guardarJugador(Jugador jugador);

	void updateJugador(String string, JugadorDTO jugadordto);

	boolean deleteJugador(String jugador_id);
}
