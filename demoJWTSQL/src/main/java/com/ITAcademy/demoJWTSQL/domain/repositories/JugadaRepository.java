package com.ITAcademy.demoJWTSQL.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ITAcademy.demoJWTSQL.domain.models.Jugada;


public interface JugadaRepository extends JpaRepository<Jugada, Integer> {

	@Query(value = "SELECT * FROM jugada", nativeQuery = true)
	List<Jugada> findByJugadorId(int jugador_id);

}
