package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugada;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.services.JugadaServiceImpl;

public class JugadorDTO {

	private int jugador_id;
	private String nombre;
	private List<Jugada> jugadas;
	


	public JugadorDTO() {
	}

	public JugadorDTO(int jugador_id, String nombre, List<Jugada> jugadas) {

		this.jugador_id = jugador_id;
		this.nombre = nombre;
		this.jugadas = jugadas;
	}

	public int getJugador_id() {
		return jugador_id;
	}

	public void setJugador_id(int jugador_id) {
		this.jugador_id = jugador_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Jugada> getJugadas() {
		return jugadas;
	}

	public void setJugadas(List<Jugada> jugadas) {
		this.jugadas = jugadas;
	}
	

}
