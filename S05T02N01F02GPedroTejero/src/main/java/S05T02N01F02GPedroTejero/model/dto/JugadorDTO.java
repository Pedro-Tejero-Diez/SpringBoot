package S05T02N01F02GPedroTejero.model.dto;

import java.util.List;

import S05T02N01F02GPedroTejero.model.domain.Jugada;

public class JugadorDTO {

	private String jugador_id;
	private String nombre;
	private List<Jugada> jugadas;
	private float exito;

	public JugadorDTO() {
	}

	public JugadorDTO(String jugador_id, String nombre, List<Jugada> jugadas) {

		this.jugador_id = jugador_id;
		this.nombre = nombre;
		this.jugadas = jugadas;
		float sumatorio = 0;
		for (int i = 0; i < jugadas.size(); i++) {
			if ((jugadas.get(i).getUno() + jugadas.get(i).getDos() == 7)) {
				sumatorio += 1;
			}
		}
		this.setExito((float) (sumatorio / jugadas.size()) * 100);
	}
	
	public JugadorDTO (String jugador_id, String nombre) {
		this.jugador_id = jugador_id;
		this.nombre = nombre;
	};

	public String getJugador_id() {
		return jugador_id;
	}

	public void setJugador_id(String jugador_id) {
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

	public float getExito() {
		return exito;
	}

	public void setExito(float exito) {
		this.exito = exito;
	}

}
