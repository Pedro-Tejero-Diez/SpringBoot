package cat.itacademy.barcelonactiva.PedroTejeroS04T02N02.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.PedroTejeroS04T02N02.model.domain.Fruta;
import cat.itacademy.barcelonactiva.PedroTejeroS04T02N02.model.repository.FrutaRepository;

@Service

public class FrutaService {

	@Autowired
	FrutaRepository frutarepository;

	public List<Fruta> getAllFrutas() {
		return frutarepository.findAll();
	}

	public Optional<Fruta> getOneFruta(int id) {
		return frutarepository.findById(id);
	}

	public Fruta addOneFruta(Fruta fruta) {

		return frutarepository.save(new Fruta(fruta.getId(), fruta.getname(), fruta.getCantidadKilos()));
	}

	public Fruta updateOneFruta(Fruta fruta, int id) {
		Optional<Fruta> fruta2 = frutarepository.findById(id);

		if (fruta2.isPresent()) {
			Fruta fruita = fruta2.get();
			fruita.setname(fruta.getname());
			fruita.setCantidadKilos(fruta.getCantidadKilos());
			frutarepository.save(fruita);
			return fruita;
		} else
			return null;
	}

	public boolean deleteOneFruta(int id) {
		Optional<Fruta> fruta = frutarepository.findById(id);

		if (fruta.isPresent()) {
			frutarepository.delete(fruta.get());
			return true;
		} else return false;
	}
}
