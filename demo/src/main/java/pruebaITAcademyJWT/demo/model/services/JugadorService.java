package pruebaITAcademyJWT.demo.model.services;

import java.util.List;

import pruebaITAcademyJWT.demo.model.domain.Jugador;
import pruebaITAcademyJWT.demo.model.dto.JugadorDTO;


public interface JugadorService {

	List<Jugador> getAllJugador();

	Jugador getJugadorbyId(String jugador_id);

	void guardarJugador(Jugador jugador);

	void updateJugador(String string, JugadorDTO jugadordto);

	boolean deleteJugador(String jugador_id);
}
