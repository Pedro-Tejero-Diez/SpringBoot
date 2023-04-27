package S05T02N01F02GPedroTejero.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import S05T02N01F02GPedroTejero.model.domain.Jugada;


 public interface JugadaRepository extends MongoRepository<Jugada, String> {

	 //List<Jugada> findByJugador(String jugador_id);
	 
	 List<Jugada> findAllByJugador(String jugador_id);
	 //@Query("{ 'jugador?: {'$oid': ?0 }")
	// List<Jugada> findByJugador(String jugador_id);
}


