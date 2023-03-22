package cat.itacademy.barcelonactiva.PedroTejeroS04T02N02.model.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import cat.itacademy.barcelonactiva.PedroTejeroS04T02N02.model.domain.Fruta;

public interface FrutaRepository extends JpaRepository<Fruta, Integer>  {

	  Optional<Fruta> findById(int id);
}
