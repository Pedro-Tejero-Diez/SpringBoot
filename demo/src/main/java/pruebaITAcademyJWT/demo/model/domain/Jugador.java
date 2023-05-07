package pruebaITAcademyJWT.demo.model.domain;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Document(collection="jugadores")
public class Jugador {
	
	@Id
	private String _id;
	private LocalDate fechareg;
	private String nombre;
	private String pwd;
	private List<Role> roles;
	//private String token;
	@ReadOnlyProperty
	@DocumentReference(lookup="{'jugador':?#{#self._id} }")
	private List<Jugada> jugadas;
	
	public Jugador() {}

	public Jugador(LocalDate fechareg, String nombre, String pwd, List<Jugada> jugadas, List<Role> roles) {
		
		
		this.fechareg = fechareg;
		this.nombre = nombre;
		this.pwd = pwd;
		this.jugadas = jugadas;
		this.roles=roles;
		
	}
	
	public Jugador(LocalDate fechareg, String nombre,String pwd, List<Role> roles) {

		
		this.fechareg = fechareg;
		this.nombre = nombre;
		this.pwd = pwd;
		this.roles=roles;
	

}
	public Jugador(LocalDate fechareg, String nombre, String pwd) {

		this.fechareg = LocalDate.now();
		this.nombre = nombre;
		this.pwd = pwd;
	}


	public String get_id() {
	return _id;
}

public void set_id(String _id) {
	this._id = _id;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}




	/*public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}*/
	
}
