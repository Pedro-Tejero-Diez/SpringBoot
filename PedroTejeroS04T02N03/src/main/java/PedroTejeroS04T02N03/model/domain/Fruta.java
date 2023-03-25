package PedroTejeroS04T02N03.model.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection="frutas")
public class Fruta {
	@Id
	private int id;
	private String name;
	private int cantidadKilos;
	
	public  Fruta() {};
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCantidadKilos() {
		return cantidadKilos;
	}
	public void setCantidadKilos(int cantidadKilos) {
		this.cantidadKilos = cantidadKilos;
	}

}
