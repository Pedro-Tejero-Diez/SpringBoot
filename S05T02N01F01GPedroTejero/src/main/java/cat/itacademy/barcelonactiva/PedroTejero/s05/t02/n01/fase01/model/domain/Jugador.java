package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jugador_id;

	@Column(name = "fecha de registro")
	private LocalDate fechareg;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "contraseña")
	private String pwd;
	
	@OneToMany(mappedBy="jugador")
    private List<Jugada> jugadas;


	public Jugador() {
		this.fechareg = LocalDate.now();
	}

	public Jugador(int jugador_id, LocalDate fechareg, String nombre, String pwd) {
	
		this.jugador_id = jugador_id;
		this.fechareg = fechareg;
		this.nombre = nombre;
		this.pwd = pwd;
	}
	
	public Jugador(LocalDate fechareg, String nombre, String pwd) {
		
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
	
	public List<Jugada> getJugadas() {
		return jugadas;
	}

	public void setJugadas(List<Jugada> jugadas) {
		this.jugadas = jugadas;
	}

	
}
