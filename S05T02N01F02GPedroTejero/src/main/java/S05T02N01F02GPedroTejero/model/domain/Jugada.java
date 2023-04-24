package S05T02N01F02GPedroTejero.model.domain;



import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="jugadas")
public class Jugada {
	
	@Id
	private int jugada_id;
	private int jugador_id;
	private LocalDate fechajug;
	private byte uno;
	private byte dos;
	
	public Jugada() {}

	public Jugada(int jugada_id, int jugador_id, LocalDate fechajug, byte uno, byte dos) {
		super();
		this.jugada_id = jugada_id;
		this.jugador_id = jugador_id;
		this.fechajug = fechajug;
		this.uno = uno;
		this.dos = dos;
	}

	public Jugada(int jugador_id, LocalDate fechajug, byte uno, byte dos) {
		super();
		this.jugador_id = jugador_id;
		this.fechajug = fechajug;
		this.uno = uno;
		this.dos = dos;
	}

	public int getJugada_id() {
		return jugada_id;
	}

	public void setJugada_id(int jugada_id) {
		this.jugada_id = jugada_id;
	}

	public int getJugador_id() {
		return jugador_id;
	}

	public void setJugador_id(int jugador_id) {
		this.jugador_id = jugador_id;
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

}
