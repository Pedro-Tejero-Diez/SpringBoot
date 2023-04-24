package S05T02N01F02GPedroTejero.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import S05T02N01F02GPedroTejero.model.domain.Jugada;


 public interface JugadaRepository extends MongoRepository<Jugada, Integer> {

}


