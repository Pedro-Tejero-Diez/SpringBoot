package S05T02N01F02GPedroTejero.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import S05T02N01F02GPedroTejero.model.domain.Jugada;

public interface JugadaRepository extends MongoRepository<Jugada, String> {

	//@Query("{ 'jugador' : {'$oid' : : #{#jugador_id}}")
	//List<Jugada> findAllByJugador_id(@Param("jugador_id") String jugador_id);
	
	//@Query("{ 'jugador' : {'$oid' : '644aa4b99363b30d6b21fc6f'}}")
	//List<Jugada> findAllByJugador_id(@Param("jugador_id") String jugador_id);

	@Query("{ 'jugador' : {'$oid' : ?0}}")
	List<Jugada> findAllByJugador_id(String jugador_id);

}
