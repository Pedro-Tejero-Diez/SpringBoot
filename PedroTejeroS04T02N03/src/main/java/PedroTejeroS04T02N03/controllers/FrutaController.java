package PedroTejeroS04T02N03.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
