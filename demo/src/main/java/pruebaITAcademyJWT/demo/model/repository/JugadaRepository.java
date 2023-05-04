package pruebaITAcademyJWT.demo.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import pruebaITAcademyJWT.demo.model.domain.Jugada;

public interface JugadaRepository extends MongoRepository<Jugada, String> {

	//@Query("{ 'jugador' : {'$oid' : : #{#jugador_id}}")
	//List<Jugada> findAllByJugador_id(@Param("jugador_id") String jugador_id);


	@Query("{ 'jugador' : {'$oid' : ?0}}")
	List<Jugada> findAllByJugador_id(String jugador_id);

}
