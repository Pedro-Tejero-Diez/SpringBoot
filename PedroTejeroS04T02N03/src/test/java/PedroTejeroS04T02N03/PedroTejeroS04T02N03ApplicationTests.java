package PedroTejeroS04T02N03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import PedroTejeroS04T02N03.controllers.FrutaController;
import PedroTejeroS04T02N03.model.domain.Fruta;


@SpringBootTest
class PedroTejeroS04T02N03ApplicationTests {

	@Test
	void TestgetAllFrutas() {
		List<Fruta> fruta = new ArrayList<Fruta>();
		FrutaController control = new FrutaController();
		assertEquals(new ResponseEntity<List<Fruta>>(fruta, HttpStatus.OK), control.getAllFrutas());
	}
        
        }

