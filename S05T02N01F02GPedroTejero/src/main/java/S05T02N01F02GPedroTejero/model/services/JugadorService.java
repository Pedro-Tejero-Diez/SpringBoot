package S05T02N01F02GPedroTejero.model.services;

import java.util.List;
import java.util.Optional;

import S05T02N01F02GPedroTejero.model.domain.Jugador;
import S05T02N01F02GPedroTejero.model.dto.JugadorDTO;

public interface JugadorService {

	List<Jugador> getAllJugador();

	Jugador getJugadorbyId(int jugador_id);

	boolean deleteJugador(int jugador_id);

	void guardarJugador(Jugador jugador);

	Optional<Jugador> updateJugador(int jugador_id, JugadorDTO jugadordto);
}
