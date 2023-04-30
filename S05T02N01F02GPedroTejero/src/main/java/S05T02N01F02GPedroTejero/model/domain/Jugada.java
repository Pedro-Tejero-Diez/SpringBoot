package S05T02N01F02GPedroTejero.model.domain;



import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection="jugadas")
public class Jugada {
	
	@Id
	private String jugada_id;
	private LocalDate fechajug;
	private byte uno;
	private byte dos;
	@DocumentReference(lazy=true)
	private Jugador jugador;
	
	public Jugada() {}

	public Jugada(LocalDate fechajug, byte uno, byte dos, Jugador jugador) {
		
		this.fechajug = fechajug;
		this.uno = uno;
		this.dos = dos;
		this.jugador=jugador;
	}

	public Jugada(Jugador jugador, LocalDate fechajug, byte uno, byte dos) {
		
		this.jugador = jugador;
		this.fechajug = fechajug;
		this.uno = uno;
		this.dos = dos;
	}

	public String getJugada_id() {
		return jugada_id;
	}

	public void setJugada_id(String jugada_id) {
		this.jugada_id = jugada_id;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
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
