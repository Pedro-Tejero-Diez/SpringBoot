package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jugador_id;

	@Column(name = "fecha de registro")
	private Date fechareg;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "contraseña")
	private String pwd;

	public Jugador() {
	}

	public Jugador(int jugador_id, Date fechareg, String nombre, String pwd) {
	
		this.jugador_id = jugador_id;
		this.fechareg = fechareg;
		this.nombre = nombre;
		this.pwd = pwd;
	}
	
	public Jugador(Date fechareg, String nombre, String pwd) {
		
		this.fechareg = fechareg;
		this.nombre = nombre;
		this.pwd = pwd;
	}


	public int getJugador_id() {
		return jugador_id;
	}

	public void setJugador_id(int jugador_id) {
		this.jugador_id = jugador_id;
	}

	public Date getFechareg() {
		return fechareg;
	}

	public void setFechareg(Date fechareg) {
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
	
}
