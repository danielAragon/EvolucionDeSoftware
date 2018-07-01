package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.service.protocol.IEstadoBusService;

@Controller
@RequestMapping("/estados")
public class EstadoBusController {
	@Autowired
	public IEstadoBusService estadoService;
	
	@GetMapping
	public String Listar(Model model) {
		model.addAttribute(estadoService.Map());
		model.addAttribute("estados", estadoService.findAll());
		return "Listado de Todos los Estados de los Buses /estados";
	}
	
//	@GetMapping(value = "/estados/{estdo_id}")
//	public String estadoFindOne(Model model, @PathVariable(required = false, name = "estado_id") String estado_id ) {
//		if(estado_id != null) {
//			model.addAttribute("estado", estadoService.findOne(Integer.parseInt(estado_id)));
//		}else{
//			model.addAttribute("estado", null);
//		}
//		return "Encontrar un solo Estado de Bus /estados";
//	}
//	
//	@GetMapping(value =  "/estados/{bus_id}")
//	public String estadoFindByBusID(Model model, @PathVariable(required = false, name = "bus_id") String bus_id) {
//		if(!bus_id.isEmpty()) {
//			model.addAttribute("estados", estadoService.filterByBusID(bus_id));
//		}else {
//			model.addAttribute("estados", new ArrayList<Object>());
//		}
//		return "Estadio encontrado por BusID";
//	}
//	
//	@GetMapping(value = "/estados/{fecha}")
//	public String estadoFindByDate(Model model, @PathVariable(required = false, name = "fecha") Date fecha) {
//		if(fecha != null) {
//			model.addAttribute("estados", estadoService.filterByDate(fecha));
//		}else {
//			model.addAttribute("estados", new ArrayList<Object>());
//		}
//		return "Estados Por hecha";
//	}
//	
//	@GetMapping(value = "/estados/{Fmin}/{Fmax}")
//	public String estadoFindByRangeDate(Model model, @PathVariable("Fmin") Date Fmin, @PathVariable("Fmax") Date Fmax) {
//		if(Fmin != null && Fmax != null) {
//			model.addAttribute("estados", estadoService.filterByRangeDate(Fmin, Fmax));
//		}else {
//			model.addAttribute("estados", new ArrayList<Object>());
//		}
//		return "Estados por Rango de Fecha";
//	}
//	
//	@GetMapping(value = "/estados/{ruta}")
//	public String estadoFindByRuta(Model model, @PathVariable(required = false, name = "ruta") String ruta) {
//		if(ruta != null) {
//			model.addAttribute("estados", estadoService.filterByRoute(ruta));
//		}else {
//			model.addAttribute("estados", new ArrayList<Object>());
//		}
//		return "Esados Por Ruta";
//	}
//	
//	@GetMapping(value = "/estado/{bus_id}/{fecha}")
//	public String estadoFindByBusIDandDate(Model model, @PathVariable("bus_id") String bus_id, @PathVariable("fecha")Date fecha) {
//		if(fecha != null && bus_id != null) {
//			model.addAttribute("estados", estadoService.filterByBusIDandDate(bus_id, fecha));
//		}else {
//			model.addAttribute("estados", new ArrayList<Object>());
//		}
//		return "Estados Por BusID y Fecha";
//	}
//	
//	@GetMapping(value = "/estado/{bus_id}/{Fmin}/{Fmax}")
//	public String estadoFindByBusIDandRangeDate(Model model, 
//			@PathVariable("bus_id") String bus_id, 
//			@PathVariable("Fmin") Date Fmin, @PathVariable("Fmax") Date Fmax) {
//		if(Fmin != null && Fmax != null && bus_id != null) {
//			model.addAttribute("estados", estadoService.filterByBusIDandRangeDate(bus_id, Fmin, Fmax));
//		}else {
//			model.addAttribute("estados", new ArrayList<Object>());
//		}
//		return "Estados por BusID y Rango de Fecha";
//	}
	
}
