package cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.dto;

import java.util.ArrayList;
import java.util.List;

public class SucursalDTO {

	private Integer id;
	private String name;
	private String pais;
	private String tipoSucursal;

	public SucursalDTO() {
	};

	public SucursalDTO(int id, String name, String pais) {
		this.id = id;
		this.name = name;
		this.pais = pais;
		this.tipoSucursal=ubicacion(pais);
	}

	public SucursalDTO(int id, String name, String pais, String tiposucursal) {
		this.id = id;
		this.name = name;
		this.pais = pais;
		this.tipoSucursal = tiposucursal;

	}

	public SucursalDTO(Integer id, String name, String pais, String tipoSucursal) {

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
	
	public String ubicacion (String pais) {
		List<String>paises=new ArrayList<String>();
		paises.add("Portugal");
		paises.add("España");
		paises.add("Francia");
		paises.add("Italia");
		paises.add("Grecia");
		
		int i = 0;
		boolean match = false;
		while (i < paises.size() && !match) {
			if (paises.get(i).equalsIgnoreCase(pais)) {
				match = true;
				
			}
			i++;
		}
		if (match) {
			return "UE";

		} else
			return "no UE";

	}

}
