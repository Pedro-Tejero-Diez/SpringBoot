package pruebaITAcademyJWT.demo.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import pruebaITAcademyJWT.demo.model.domain.Jugador;

 public interface JugadorRepository extends MongoRepository<Jugador, String> {

}
