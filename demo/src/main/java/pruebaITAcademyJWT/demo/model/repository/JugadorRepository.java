package pruebaITAcademyJWT.demo.model.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import pruebaITAcademyJWT.demo.model.domain.Jugador;

 public interface JugadorRepository extends MongoRepository<Jugador, String> {
	 
	 Optional<Jugador> findByNombre(String nombre);
	 
	// Boolean existsByJugadorNombre (String nombre);

}
