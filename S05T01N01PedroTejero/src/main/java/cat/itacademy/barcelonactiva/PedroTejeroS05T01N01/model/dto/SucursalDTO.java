package cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.dto;


import java.util.Arrays;
import java.util.List;

public class SucursalDTO {

	private Integer id;
	private String name;
	private String pais;
	private String tipoSucursal;

	public SucursalDTO() {
	};

	public SucursalDTO(String name, String pais) {

		this.name = name;
		this.pais = pais;

	}

	public SucursalDTO(String name, String pais, String tiposucursal) {

		this.name = name;
		this.pais = pais;
		this.tipoSucursal = tiposucursal;

	}

	public SucursalDTO(Integer id, String name, String pais, String tipoSucursal) {
		super();
		this.id = id;
		this.name = name;
		this.pais = pais;
		this.tipoSucursal = tipoSucursal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTipoSucursal() {
		return tipoSucursal;
	}

	public void setTipoSucursal(String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}

	public List<String> addcountry() {
		return Arrays.asList("España", "Portugal", "Italia", "Grecia", "Francia", "Austria");

	}

}
