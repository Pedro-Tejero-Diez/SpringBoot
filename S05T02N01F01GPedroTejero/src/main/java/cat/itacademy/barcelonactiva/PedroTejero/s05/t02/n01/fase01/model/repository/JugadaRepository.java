package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugada;

public interface JugadaRepository extends JpaRepository<Jugada, Integer> {

	// @Query("FROM jugada WHERE jugador_id =?1")
	// List<Jugada> findByJugadorId(int jugador_id);
	//@Query("SELECT * FROM jugada jg WHERE jg.jugador_id = :jugador_id")
	//List<Jugada> findByJugadorId(@Param("jugador_id") int jugador_id);
	@Query(value="SELECT * FROM jugada", nativeQuery = true)
	//@Query("SELECT jg FROM Jugada j join j.jugador_id jg WHERE j.jugador_id = :jugador_id")
	List<Jugada> findByJugadorId(int jugador_id);
	//@Query( "SELECT j FROM Jugada j WHERE j.jugador_id = ?1")
	 //List<Jugada> findByJugadorId(int jugador_id);

}
