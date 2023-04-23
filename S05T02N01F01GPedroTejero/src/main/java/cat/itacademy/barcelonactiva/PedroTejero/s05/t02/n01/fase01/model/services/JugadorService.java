package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugador;

public interface JugadorService {

	List<Jugador> getAllJugador();

	Jugador getJugadorbyId(int jugador_id);

	boolean deleteJugador(int jugador_id);

	void guardarJugador(Jugador jugador);

}
