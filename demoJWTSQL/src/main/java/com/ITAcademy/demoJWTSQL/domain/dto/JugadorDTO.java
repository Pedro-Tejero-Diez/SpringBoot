package com.ITAcademy.demoJWTSQL.domain.dto;

import java.util.List;

import com.ITAcademy.demoJWTSQL.domain.models.Jugada;


public class JugadorDTO {

	private int jugador_id;
	private String nombre;
	private List<Jugada> jugadas;
	private float exito;

	public JugadorDTO() {
	}

	public JugadorDTO(int jugador_id, String nombre, List<Jugada> jugadas) {

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

	public float getExito() {
		return exito;
	}

	public void setExito(float exito) {
		this.exito = exito;
	}

}
