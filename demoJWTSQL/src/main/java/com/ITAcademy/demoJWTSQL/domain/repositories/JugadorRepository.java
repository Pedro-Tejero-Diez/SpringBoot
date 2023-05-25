package com.ITAcademy.demoJWTSQL.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITAcademy.demoJWTSQL.domain.models.Jugador;


public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

	Optional<Jugador> findById(int jugador_id);
	
	Optional<Jugador> findByNombre(String username);
	
	
	Boolean existsByUsername(String username);

}
