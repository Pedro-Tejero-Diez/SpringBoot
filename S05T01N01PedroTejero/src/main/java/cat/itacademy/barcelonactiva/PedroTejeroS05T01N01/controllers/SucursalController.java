package cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.controllers;

import java.util.stream.Collectors;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.dto.SucursalCreationDTO;
import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.dto.SucursalMapper;
import cat.itacademy.barcelonactiva.PedroTejeroS05T01N01.model.services.SucursalServiceImpl;

@Controller
@RequestMapping("/Sucursal")
public class SucursalController {

	@Autowired
	SucursalServiceImpl sucursalserviceimpl;

	@GetMapping("/getAll")
	public String getAll(Model model) {
		try {
			model.addAttribute("listaSucursales", sucursalserviceimpl.getAllSucursal().stream()
					.map(SucursalMapper::toSucursalDto).collect(Collectors.toList()));
			return "index";
		} catch (Exception e) {
			
			return "/Sucursal/error";
		}
	}

	@GetMapping("/getOne/{id}")
	public String mostrarUna(@PathVariable(value = "id") int id, Model model) {

		try {
			Sucursal sucursal = sucursalserviceimpl.getSucursalbyId(id);
			if (sucursal != null) {
				SucursalDTO sucursaldto = SucursalMapper.toSucursalDto(sucursal);
				model.addAttribute("SucursalDTO", sucursaldto);
				return "showone";
			} else
				return "sucursal no encontrada";
		} catch (Exception e) {
			return "/Sucursal/error";
		}
	}

	@GetMapping("/nuevasucursal")
	public String nuevaSucursal(Model model) {
		SucursalDTO sucursaldto = new SucursalDTO();
		model.addAttribute("sucursaldto", sucursaldto);
		return "new_Sucursal";
	}

	@PostMapping("/add")
	public String guardarSucursalDTO(@ModelAttribute("sucursaldto") SucursalDTO sucursaldto) {
		sucursalserviceimpl.saveSucursal(SucursalMapper.toSucursal(sucursaldto));
		return "/Sucursal/getAll";
	}

	@PutMapping("/update")
	public String actualizarSucursal(@ModelAttribute("sucursalDTO") SucursalDTO sucursaldto) {
		sucursalserviceimpl.saveSucursal(SucursalMapper.toSucursal(sucursaldto));
		return "/Sucursal/getAll";
	}

	@GetMapping("/deleteSucursal/{id}")
	public String borrarSucursal(@PathVariable(value = "id") int id) {
		//try {
			if (sucursalserviceimpl.deleteSucursal(id)) {

				return "/Sucursal/getAll";
			} else {
				return "datos no encontrados";
			}
		/*} catch (Exception e) {
			return "/Sucursal/error";
		}*/
	}
}
