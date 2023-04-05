package cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.controllers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.dto.SucursalMapper;
import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.services.SucursalServiceImpl;

@RestController
@RequestMapping("/Sucursal")
public class SucursalController {
	
	@Autowired
	SucursalServiceImpl sucursalserviceimpl;
	
	@GetMapping
	public List<SucursalDTO> getAll () {
		return sucursalserviceimpl.getAllSucursal().stream().map(SucursalMapper::toSucursalDto)
		          .collect(Collectors.toList());
	}

	
	
	

	
}
