package cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.repository.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {

	@Autowired
	SucursalRepository sucursalrepository;

	@Override
	public List<Sucursal> getAllSucursal() {
		return sucursalrepository.findAll();
	}

	@Override
	public void saveSucursal(Sucursal sucursal) {
		this.sucursalrepository.save(sucursal);
	}

	@Override
	public Sucursal getSucursalbyId(int id) {

		Optional<Sucursal> sucursal = sucursalrepository.findById(id);
		if (sucursal.isPresent()) {
			Sucursal sucursal1 = sucursal.get();
			return sucursal1;
		} else
			return null;

	}

	@Override
	public boolean deleteSucursal(int id) {

		Optional<Sucursal> sucursal = sucursalrepository.findById(id);
		if (sucursal.isPresent()) {
			sucursalrepository.deleteById(sucursal.get().getPk_SucursalID());
			return true;
		} else return false;

	}

}
