package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.entity.Trabajador;
import com.example.demo.models.service.protocol.ITrabajadorService;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {

	@Autowired
	public ITrabajadorService trabajadorService;

	@GetMapping
	public String listar(Model model) {
		model.addAllAttributes(trabajadorService.Map());
		model.addAttribute("trabajadores",trabajadorService.findAll());
		return "trabajadores";
	}
	@GetMapping({"/add","/edit/{trabajadorID"})
	public String trabajadorAddEdit(Model model, @PathVariable(required = false, name = "trabajadorID") String trabajadorID) {
		if (null != trabajadorID) {
			model.addAttribute("title", trabajadorService.Map().get("editTitle"));
			model.addAttribute("submitValue", trabajadorService.Map().get("edit"));
			model.addAttribute("trabajador", trabajadorService.findById(trabajadorID));
		} else {
			model.addAttribute("title", trabajadorService.Map().get("addTitle"));
			model.addAttribute("submitValue", trabajadorService.Map().get("add"));
			model.addAttribute("trabajador", new Trabajador());
		}
		return "trabajadorAddEdit";
	}
	@PostMapping("/add")
	public String rutaUpdate(Model model, Trabajador trabajador) {
		//bus.setFechaCompra(Date.parse("2017-12-12"));
		trabajadorService.save(trabajador);
		model.addAllAttributes(trabajadorService.Map());
		model.addAttribute("trabajadores", trabajadorService.findAll());
		return "trabajadores";
	}
}
