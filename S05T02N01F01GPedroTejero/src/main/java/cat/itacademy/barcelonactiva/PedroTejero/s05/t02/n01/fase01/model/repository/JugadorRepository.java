package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

	Optional<Jugador> findById(int jugador_id);

}
