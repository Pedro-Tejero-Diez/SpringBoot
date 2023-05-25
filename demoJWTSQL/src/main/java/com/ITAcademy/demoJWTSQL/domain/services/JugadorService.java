package com.ITAcademy.demoJWTSQL.domain.services;

import java.util.List;

import com.ITAcademy.demoJWTSQL.domain.models.Jugador;


public interface JugadorService {

	List<Jugador> getAllJugador();

	Jugador getJugadorbyId(int jugador_id);

	boolean deleteJugador(int jugador_id);

	void guardarJugador(Jugador jugador);

}
