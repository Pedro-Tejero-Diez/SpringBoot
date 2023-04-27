package S05T02N01F02GPedroTejero.model.dto;

import java.time.LocalDate;

import S05T02N01F02GPedroTejero.model.domain.Jugador;

public class JugadaDTO {

	
	private LocalDate fechajug;
	private byte uno;
	private byte dos;
	private boolean win;
	private Jugador jugador;

	public JugadaDTO() {
	};

	public JugadaDTO(Jugador jugador) {
		byte min = 1;
		byte max = 6;
		this.jugador = jugador;
		this.fechajug = LocalDate.now();
		this.uno = (byte) Math.floor(Math.random() * (max - min + 1) + min);
		this.dos = (byte) Math.floor(Math.random() * (max - min + 1) + min);
		this.win = (uno + dos == 7) ? true : false;
	}

	public JugadaDTO(Jugador jugador, LocalDate fechajug, byte uno, byte dos) {

		this.setJugador(jugador);
		this.fechajug = fechajug;
		this.uno = uno;
		this.dos = dos;
		this.win = (uno + dos == 7) ? true : false;
		;
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

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

}
