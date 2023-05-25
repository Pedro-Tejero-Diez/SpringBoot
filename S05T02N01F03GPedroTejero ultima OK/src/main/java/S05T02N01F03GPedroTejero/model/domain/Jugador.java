package S05T02N01F03GPedroTejero.model.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Document(collection = "jugadores")
public class Jugador {

	@Id
	private String _id;
	private LocalDate fechareg;
	private String nombre;
	private String pwd;
	private List<Role> roles;
	@ReadOnlyProperty
	@DocumentReference(lookup = "{'jugador':?#{#self._id} }")
	private List<Jugada> jugadas;

	public Jugador() {
	}

	public Jugador(LocalDate fechareg, String nombre, String pwd, List<Jugada> jugadas, List<Role> roles) {

		this.fechareg = LocalDate.now();
		this.nombre = nombre;
		this.jugadas = jugadas;
		this.roles = roles;
		this.pwd = passwordEncoder().encode(pwd);

	}

	public Jugador(LocalDate fechareg, String nombre, String pwd, List<Role> roles) {

		this.fechareg = LocalDate.now();;
		this.nombre = nombre;
		this.pwd = passwordEncoder().encode(pwd);
		this.roles = roles;

	}

	public Jugador(LocalDate fechareg, String nombre, String pwd) {

		this.fechareg = LocalDate.now();
		this.nombre = nombre;
		this.pwd = passwordEncoder().encode(pwd);
	}

	public Jugador(String nombre, String pwd) {

		this.fechareg = LocalDate.now();
		this.nombre = nombre;
		this.pwd = passwordEncoder().encode(pwd);
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

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
