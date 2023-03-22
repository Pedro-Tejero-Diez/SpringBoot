package cat.itacademy.barcelonactiva.PedroTejeroS04T02N02.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name="Frutas")
public class Fruta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="NOMBRE")
	String name;
	@Column(name="KILOS")
	int cantidadKilos;
	
	public Fruta() {};
	
	public Fruta(String name, int cantidadKilos) {
		this.name = name;
		this.cantidadKilos = cantidadKilos;
	}
	
	public Fruta(int id, String name, int cantidadKilos) {
		this.id = id;
		this.name = name;
		this.cantidadKilos = cantidadKilos;
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
		return cantidadKilos;
	}

	public void setCantidadKilos(int cantidadKilos) {
		this.cantidadKilos = cantidadKilos;
	}

}
