package cat.itacademy.barcelonactiva.PedroTejero.s04.t02.n01.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import cat.itacademy.barcelonactiva.PedroTejero.s04.t02.n01.model.domain.Fruta;

//esta interface nos permite acceder, entre otros, a los métodos CRUD de JPArepository
public interface FrutaRepository extends JpaRepository<Fruta, Integer> {
	
  List<Fruta> findByName(String name);

  Optional<Fruta> findById(int id);


}
