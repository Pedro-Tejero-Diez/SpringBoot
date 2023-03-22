package cat.itacademy.barcelonactiva.PedroTejeroS04T02N02.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.PedroTejeroS04T02N02.model.domain.Fruta;
import cat.itacademy.barcelonactiva.PedroTejeroS04T02N02.model.services.FrutaService;

@RestController
@RequestMapping("/frutas")

public class FrutaController {

	@Autowired
	FrutaService frutaservice;

	@GetMapping("/getAll")
	public ResponseEntity<List<Fruta>> getAll() {

		try {
			List<Fruta> frutas = frutaservice.getAllFrutas();

			if (frutas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			} else
				return new ResponseEntity<>(frutas, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruta> getOne(@PathVariable("id") int id) {
		Optional<Fruta> frutaData = frutaservice.getOneFruta(id);
		if (frutaData.isPresent()) {
			return new ResponseEntity<>(frutaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Fruta> addOne(@RequestBody Fruta fruta) {
		try {
			Fruta fruta2 = frutaservice.addOneFruta(fruta);
			return new ResponseEntity<Fruta>(fruta2, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Fruta> updateOne(@PathVariable("id") int id, @RequestBody Fruta fruta) {

		try {
			Fruta fruta2 = frutaservice.updateOneFruta(fruta, id);
			if (fruta2 != null) {
				return new ResponseEntity<Fruta>(fruta2, HttpStatus.CREATED);
			} else
				return new ResponseEntity<Fruta>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOne(@PathVariable int id) {

		try {
			if (frutaservice.deleteOneFruta(id)) {
				return new ResponseEntity<String>(HttpStatus.OK);
			} else
				return new ResponseEntity<String>("registro no encontrado", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}