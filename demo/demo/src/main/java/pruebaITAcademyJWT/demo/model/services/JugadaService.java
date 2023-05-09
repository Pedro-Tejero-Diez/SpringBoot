package pruebaITAcademyJWT.demo.model.services;

import java.util.List;

import pruebaITAcademyJWT.demo.model.domain.Jugada;
import pruebaITAcademyJWT.demo.model.dto.JugadaDTO;


public interface JugadaService {
	
	List<Jugada> getAllJugada();

	void guardarJugada(JugadaDTO jugadadto);

	List<Jugada> getAllJugadabyJugador(String jugador_id);

	void eliminarJugadas(String id);

}

