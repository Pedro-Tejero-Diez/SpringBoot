package PedroTejeroS04T02N03.model.services;

import java.util.List;

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

}
