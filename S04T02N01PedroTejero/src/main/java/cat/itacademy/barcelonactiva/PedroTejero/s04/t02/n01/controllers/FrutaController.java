package cat.itacademy.barcelonactiva.PedroTejero.s04.t02.n01.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.PedroTejero.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.PedroTejero.s04.t02.n01.model.repository.FrutaRepository;

@RestController
@RequestMapping("/fruta")//para que todas las path empiecen por "fruta"
public class FrutaController {

	@Autowired //inyección de la dependencia para poder usar los métodos existentes y los que creemos nosotros en frutarepository
	FrutaRepository frutaRepository;

	@GetMapping("/getAll")
	public ResponseEntity<List<Fruta>> getAllFrutas(@RequestParam(required = false) String name) {
		try {
			List<Fruta> frutas = new ArrayList<Fruta>();	
			
			if (name == null)
				frutaRepository.findAll().forEach(frutas::add);
			else
				frutaRepository.findByName(name).forEach(frutas::add);

			if (frutas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				
			} else 	return new ResponseEntity<>(frutas, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruta> getOneFruta(@PathVariable("id") int id) {
		Optional <Fruta> frutaData = frutaRepository.findById(id);

		if (frutaData.isPresent()) {
			return new ResponseEntity<>(frutaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Fruta> createFruta(@RequestBody Fruta fruta) {
		try {
			//esto de abajo no funciona, tiene que ser a través de frutarepository.porque?
			//Fruta fruta2= new Fruta(fruta.getId(), fruta.getname(), fruta.getCantidadKilos());
			Fruta fruta2 = frutaRepository.save(new Fruta(fruta.getId(), fruta.getname(), fruta.getCantidadKilos()));
			return new ResponseEntity<>(fruta2, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Fruta> updateFruta(@PathVariable("id") int id, @RequestBody Fruta fruta) {
		Optional<Fruta> FrutaData = frutaRepository.findById(id);

		if (FrutaData.isPresent()) {
			Fruta fruta2 = FrutaData.get();
			fruta2.setId(fruta.getId());
			fruta2.setname(fruta.getname());
			fruta2.setCantidadKilos(fruta.getCantidadKilos());
			return new ResponseEntity<>(frutaRepository.save(fruta2), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		/*	public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
		Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

		if (tutorialData.isPresent()) {
			Tutorial _tutorial = tutorialData.get();
			_tutorial.setTitle(tutorial.getTitle());
			_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setPublished(tutorial.isPublished());
			return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteFruta(@PathVariable("id") int id) {
		try {
			frutaRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

