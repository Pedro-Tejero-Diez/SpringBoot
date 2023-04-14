package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugada;

public interface JugadaRepository extends JpaRepository<Jugada, Integer>{
	
	@Query("FROM Jugador WHERE jugador_id =?1")
	List<Jugada> findByJugadorId(int jugador_id);
}
