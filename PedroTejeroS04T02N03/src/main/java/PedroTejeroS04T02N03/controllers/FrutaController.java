package PedroTejeroS04T02N03.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import PedroTejeroS04T02N03.model.domain.Fruta;
import PedroTejeroS04T02N03.model.services.FrutaServices;

@RestController
@RequestMapping("/fruta")
public class FrutaController {

	@Autowired
	FrutaServices service;

	@GetMapping("/getAll")
	public ResponseEntity<List<Fruta>> getAllFrutas() {
		try {

			List<Fruta> frutas = service.getAllFrutas();

			if (frutas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			} else
				return new ResponseEntity<>(frutas, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Fruta> addOne(@RequestBody Fruta fruta) {
		try {
			Fruta fruta2 = service.addOneFruta(fruta);
			return new ResponseEntity<Fruta>(fruta2, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruta> getOne(@PathVariable int id) {
		Optional<Fruta> fruta = service.getOneFruta(id);
		try {
			if (fruta.isPresent()) {
				return new ResponseEntity<Fruta>(fruta.get(), HttpStatus.OK);
			} else
				return new ResponseEntity<Fruta>(HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<Fruta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("update/{id}")
	public ResponseEntity<Fruta> update(@PathVariable int id, @RequestBody Fruta fruta) {
		Fruta fruta2 = service.updateFruta(id, fruta);
		try {
			if (fruta2 != null) {
				return new ResponseEntity<Fruta>(fruta2, HttpStatus.OK);
			} else
				return new ResponseEntity<Fruta>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Fruta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@RequestParam int id) {
		try {
			if (service.deleteOneFruta(id)) {
				return new ResponseEntity<String> ("elemento eliminado", HttpStatus.OK);
			} else return new ResponseEntity<String> ("elemento no encontrado", HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<String>("excepción", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
