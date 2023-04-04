package cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SucursalDTO {
	
	private Integer id;
	private String name;
	private  String pais;
	private String tipoSucursal;
	private ArrayList<String> paises= (ArrayList<String>) Arrays.asList("España", "Portugal", "Italia", "Grecia", "Francia", "Austria");
	
	
	public SucursalDTO () {};

	public SucursalDTO(String name, String pais) {
		
		this.name = name;
		this.pais = pais;
		int i=0;
		while(pais!=index) {
			
		}
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

	public ArrayList<String> getPaises() {
		return paises;
	}

	public void setPaises(ArrayList<String> paises) {
		this.paises = paises;
	}
	
	public List<String> addcountry () {
		return Arrays.asList("España", "Portugal", "Italia", "Grecia", "Francia", "Austria");
		
	}
	
	

}
