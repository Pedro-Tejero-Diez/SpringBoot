package cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sucursales")
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pk_SucursalID;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Pais")
	private String pais;
	
	public Sucursal () {}

	public Sucursal(Integer pk_SucursalID, String nombre, String pais) {
		this.pk_SucursalID = pk_SucursalID;
		this.nombre = nombre;
		this.pais = pais;
	}

	public Integer getPk_SucursalID() {
		return pk_SucursalID;
	}

	public void setPk_SucursalID(Integer pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	};
	
	
	
	
	

}
