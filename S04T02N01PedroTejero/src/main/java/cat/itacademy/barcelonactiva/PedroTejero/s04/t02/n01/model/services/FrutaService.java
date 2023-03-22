package cat.itacademy.barcelonactiva.PedroTejero.s04.t02.n01.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.PedroTejero.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.PedroTejero.s04.t02.n01.model.repository.FrutaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FrutaService {

	@Autowired
	FrutaRepository frutarepository;

	public List<Fruta> getAllFrutas() {
		return frutarepository.findAll();
	}

}
