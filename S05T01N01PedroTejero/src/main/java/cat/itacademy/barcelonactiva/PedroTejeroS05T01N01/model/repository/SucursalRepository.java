package cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.domain.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

	 Optional<Sucursal> findById(Integer id);
}
