package com.ITAcademy.demoJWTSQL.domain.models;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jugador_id;

	@Column(name = "fecha de registro")
	private LocalDate fechareg;

	@Column(name = "username")
	private String username;

	@Column(name = "contraseña")
	private String password;

	@OneToMany(mappedBy = "jugador")
	private List<Jugada> jugadas;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public Jugador() {
	}

	public Jugador(int jugador_id, LocalDate fechareg, String username, String password, List<Jugada> jugadas) {

		this.jugador_id = jugador_id;
		this.fechareg = fechareg;
		this.username = username;
		this.password = password;
		this.jugadas = jugadas;
	}

	public Jugador(int jugador_id, LocalDate fechareg, String username, String password) {

		this.jugador_id = jugador_id;
		this.fechareg = fechareg;
		this.username = username;
		this.password = password;
	}

	public Jugador(LocalDate fechareg, String username, String password) {

		this.fechareg = fechareg;
		this.username = username;
		this.password = password;
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
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
