package cat.itacademy.barcelonactiva.PedroTejero.s04.t02.n01.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "frutas")
public class Fruta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "Cantidad")
	private int CantidadKilos;
	
	public Fruta() {};
	
	public Fruta(String name, int cantidadKilos) {
		this.name = name;
		this.CantidadKilos = cantidadKilos;
	}
	
	public Fruta(int id, String name, int cantidadKilos) {
		this.id = id;
		this.name = name;
		this.CantidadKilos = cantidadKilos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getCantidadKilos() {
		return CantidadKilos;
	}

	public void setCantidadKilos(int cantidadKilos) {
		CantidadKilos = cantidadKilos;
	}
	@Override
	public String toString() {
		return "Fruta id=" + id + ", name=" + name + ", Cantidad=" + CantidadKilos;
	}
	

}
