package S05T02N01F03GPedroTejero.model.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Document(collection = "jugadores")
public class Jugador {

	@Id
	private String _id;
	private LocalDate fechareg;
	private String username;
	private String password;
	@DBRef
	private List<Role> roles;
	@ReadOnlyProperty
	@DocumentReference(lookup = "{'jugador':?#{#self._id} }")
	private List<Jugada> jugadas;

	public Jugador() {
	}

	public Jugador(LocalDate fechareg, String username, String password, List<Jugada> jugadas, List<Role> roles) {

		this.fechareg = LocalDate.now();
		this.username = username;
		this.jugadas = jugadas;
		this.roles = roles;
		this.password = password;

	}

	public Jugador(LocalDate fechareg, String username, String password, List<Role> roles) {

		this.fechareg = LocalDate.now();;
		this.username = username;
		this.password = password;
		this.roles = roles;

	}

	public Jugador(LocalDate fechareg, String username, String password) {

		this.fechareg = LocalDate.now();
		this.username = username;
		this.password = password;
	}

	public Jugador(String username, String password) {

		this.fechareg = LocalDate.now();
		this.username = username;
		this.password = password;
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

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
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

}
