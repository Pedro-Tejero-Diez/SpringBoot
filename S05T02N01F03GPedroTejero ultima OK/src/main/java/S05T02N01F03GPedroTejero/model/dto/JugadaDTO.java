package S05T02N01F03GPedroTejero.model.dto;

import java.time.LocalDate;

public class JugadaDTO {

	private String jugador_id;
	private LocalDate fechajug;
	private byte uno;
	private byte dos;
	private boolean win;

	public JugadaDTO() {
	};

	public JugadaDTO(JugadorDTO jugadordto) {

		this.jugador_id = jugadordto.getJugador_id();
		byte min = 1;
		byte max = 6;
		this.fechajug = LocalDate.now();
		this.uno = (byte) Math.floor(Math.random() * (max - min + 1) + min);
		this.dos = (byte) Math.floor(Math.random() * (max - min + 1) + min);
		this.win = ((uno + dos == 7) ? true : false);
	}

	public JugadaDTO(String jugador_id, LocalDate fechajug, byte uno, byte dos) {

		this.setJugador_id(jugador_id);
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

	public String getJugador_id() {
		return jugador_id;
	}

	public void setJugador_id(String jugador_id) {
		this.jugador_id = jugador_id;
	}

}
