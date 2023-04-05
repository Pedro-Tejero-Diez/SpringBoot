package cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.controllers;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.dto.SucursalMapper;
import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.services.SucursalServiceImpl;

@Controller
@RequestMapping("/Sucursal")
public class SucursalController {
	
	@Autowired
	SucursalServiceImpl sucursalserviceimpl;
	
	@GetMapping("/getAll")
	public String getAll (Model model) {
		try {
		model.addAttribute("listaSucursales", sucursalserviceimpl.getAllSucursal()
				.stream()
				.map(SucursalMapper::toSucursalDto)
		          .collect(Collectors.toList()));
		return "index";
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return "error";
	}
		
	}

	
	
	

	
}
