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
	public Optional<Sucursal> getSucursalbyId(int id) {

		return sucursalrepository.findById(id);
	}

	@Override
	public void deleteSucursal(int id) {
		sucursalrepository.deleteById(id);

	}

}
