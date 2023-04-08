package cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.services;

import java.util.List;
import java.util.Optional;

import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.domain.Sucursal;

public interface SucursalService {

	List<Sucursal> getAllSucursal ();
	void saveSucursal (Sucursal sucursal);
	Sucursal getSucursalbyId (int id);
	void deleteSucursal (int id);
	
	
}
