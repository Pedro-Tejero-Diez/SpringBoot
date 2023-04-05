package cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.dto;

import org.springframework.stereotype.Component;

import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.domain.Sucursal;

@Component
public class SucursalMapper {
	
	    public static SucursalDTO toSucursalDto(Sucursal sucursal) {
	    	Integer id = sucursal.getPk_SucursalID();
	        String nombre = sucursal.getNombre();
	        String pais = sucursal.getPais();
	        String tiposucursal="UE";
	        

	        return new SucursalDTO(id, nombre, pais, tiposucursal);
	    }

	  /*  public Sucursal toSucursal (UserCreationDTO userDTO) {
	        return new User(userDTO.getName(), userDTO.getPassword(), new ArrayList<>());
	    }*/
	}

