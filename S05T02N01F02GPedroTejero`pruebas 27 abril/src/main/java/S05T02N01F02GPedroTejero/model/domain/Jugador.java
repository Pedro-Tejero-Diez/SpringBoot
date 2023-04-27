package S05T02N01F02GPedroTejero.model.domain;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="jugadores")
public class Jugador {
	@Id
	private String jugador_id;
	private LocalDate fechareg;
	private String nombre;
	private String pwd;
	//	@DocumentReference
	//private List<Jugada> jugadas;
	
	public Jugador() {}

	/*public Jugador(String jugador_id, LocalDate fechareg, String nombre, String pwd, List<Jugada> jugadas) {
		
		this.jugador_id = jugador_id;
		this.fechareg = fechareg;
		this.nombre = nombre;
		this.pwd = pwd;
		this.jugadas = jugadas;
	}*/
	
	public Jugador(String jugador_id, LocalDate fechareg, String nombre, String pwd) {

		this.jugador_id = jugador_id;
		this.fechareg = LocalDate.now();
		this.nombre = nombre;
		this.pwd = pwd;

}
	public Jugador(LocalDate fechareg, String nombre, String pwd) {

		this.fechareg = fechareg;
		this.nombre = nombre;
		this.pwd = pwd;
	}

	public String getJugador_id() {
		return jugador_id;
	}

	public void setJugador_id(String jugador_id) {
		this.jugador_id = jugador_id;
	}

	public LocalDate getFechareg() {
		return fechareg;
	}

	public void setFechareg(LocalDate fechareg) {
		this.fechareg = fechareg;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/*public List<Jugada> getJugadas() {
		return jugadas;
	}

	public void setJugadas(List<Jugada> jugadas) {
		this.jugadas = jugadas;
	}*/
	
}
