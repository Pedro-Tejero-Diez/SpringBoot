package S05T02N01F02GPedroTejero.model.services;

import java.util.List;
import java.util.Optional;

import S05T02N01F02GPedroTejero.model.domain.Jugador;
import S05T02N01F02GPedroTejero.model.dto.JugadaDTO;
import S05T02N01F02GPedroTejero.model.dto.JugadorDTO;

public interface JugadorService {

	List<Jugador> getAllJugador();

	Jugador getJugadorbyId(String jugador_id);

	void guardarJugador(Jugador jugador);

	void updateJugador(String string, JugadorDTO jugadordto);

	boolean deleteJugador(String jugador_id);

	Optional<Jugador> updateJugadorJugada(String jugador_id, JugadaDTO jugadadto);
}