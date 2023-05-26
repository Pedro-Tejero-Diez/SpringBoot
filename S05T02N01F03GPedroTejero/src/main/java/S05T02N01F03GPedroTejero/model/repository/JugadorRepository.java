package S05T02N01F03GPedroTejero.model.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import S05T02N01F03GPedroTejero.model.domain.Jugador;

public interface JugadorRepository extends MongoRepository<Jugador, String> {

	Optional<Jugador> findByusername(String username);

	Boolean existsByJugadorusername (String username);

}
