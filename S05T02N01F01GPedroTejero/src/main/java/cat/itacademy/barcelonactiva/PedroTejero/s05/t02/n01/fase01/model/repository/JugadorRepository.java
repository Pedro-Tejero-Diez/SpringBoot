package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Integer>{

	Optional<Jugador> findById(int id);
	
	   @Query("FROM Jugador WHERE jugador_id = ?1")
	    List<Jugador> findByJugadorId(Integer id);
}
