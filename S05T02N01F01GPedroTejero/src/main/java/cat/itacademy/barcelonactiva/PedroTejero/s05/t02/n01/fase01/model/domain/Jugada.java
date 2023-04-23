package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Jugada {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jugada_id;

	@Column(name = "fecha de jugada")
	private LocalDate fechajug;

	@Column(name = "dado 1")
	private byte uno;

	@Column(name = "dado 2")
	private byte dos;

	// @ManyToOne(fetch = FetchType.LAZY, optional = false)
	// @JoinColumn(name = "jugador_id", nullable = false)
	// @OnDelete(action = OnDeleteAction.CASCADE)
	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "jugador_id", nullable = false)
	private Jugador jugador;

	public Jugada() {
	};

	public Jugada(int jugada_id, LocalDate fechajug, byte uno, byte dos, Jugador jugador) {

		this.jugada_id = jugada_id;
		this.fechajug = fechajug;
		this.uno = uno;
		this.dos = dos;
		this.jugador = jugador;
	}

	public Jugada(LocalDate fechajug, byte uno, byte dos, Jugador jugador) {

		this.fechajug = fechajug;
		this.uno = uno;
		this.dos = dos;
		this.jugador = jugador;
	}

	public int getJugada_id() {
		return jugada_id;
	}

	public void setJugada_id(int jugada_id) {
		this.jugada_id = jugada_id;
	}

	public LocalDate getFechajug() {
		return fechajug;
	}

	public void setFechajug(LocalDate fechajug) {
		this.fechajug = fechajug;
	}

	public byte getUno() {
		return uno;
	}

	public void setUno(byte uno) {
		this.uno = uno;
	}

	public byte getDos() {
		return dos;
	}

	public void setDos(byte dos) {
		this.dos = dos;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

}
