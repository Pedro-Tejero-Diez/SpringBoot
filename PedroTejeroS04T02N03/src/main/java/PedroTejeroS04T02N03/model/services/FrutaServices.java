package PedroTejeroS04T02N03.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PedroTejeroS04T02N03.model.domain.Fruta;
import PedroTejeroS04T02N03.model.repository.FrutaRepository;

@Service
public class FrutaServices {

	@Autowired
	FrutaRepository repo;

	public List<Fruta> getAllFrutas() {
		return repo.findAll();
	}

	public Fruta addOneFruta(Fruta fruta) {

		return repo.save(new Fruta(fruta.getId(), fruta.getName(), fruta.getCantidadKilos()));
	}

	public Optional<Fruta> getOneFruta(int id) {

		Optional<Fruta> fruta = repo.findById(id);
		return fruta;
	}

	public Fruta updateFruta(int id, Fruta fruta) {
		Optional<Fruta> fruta2 = repo.findById(id);
		if (fruta2.isPresent()) {
			Fruta fruta3 = fruta2.get();
			fruta3.setId(fruta.getId());
			fruta3.setName(fruta.getName());
			fruta3.setCantidadKilos(fruta.getCantidadKilos());
			repo.deleteById(id);
			repo.save(fruta3);
			return fruta3;
		} else
			return null;
	}

	public boolean deleteOneFruta(int id) {

		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		} else
			return false;
	}
}
