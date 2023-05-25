package com.ITAcademy.demoJWTSQL.domain.services;

import java.util.List;

import com.ITAcademy.demoJWTSQL.domain.dto.JugadaDTO;
import com.ITAcademy.demoJWTSQL.domain.models.Jugada;


public interface JugadaService {

	List<Jugada> getAllJugada();

	void guardarJugada(JugadaDTO jugadadto);

	List<Jugada> getAllJugadabyJugador(int jugador_id);

	Jugada getJugadabyId(int jugada_id);

	void eliminarJugadas(int jugador_id);

}
