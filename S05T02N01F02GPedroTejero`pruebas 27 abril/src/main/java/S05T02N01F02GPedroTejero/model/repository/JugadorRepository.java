package S05T02N01F02GPedroTejero.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import S05T02N01F02GPedroTejero.model.domain.Jugador;

 public interface JugadorRepository extends MongoRepository<Jugador, String> {
	 
	

}
