package com.example.demo.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.entity.Cargo;
import com.example.demo.models.service.protocol.ICargoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	public ICargoService cargoService;

	@GetMapping
	public String listar(Model model) {
		model.addAllAttributes(cargoService.Map());
		model.addAttribute("cargos",cargoService.findAll());
		return "cargos";
	}

	@GetMapping({"/add","/edit/{cargoID}"})
	public String cargoAddEdit(Model model, @PathVariable(required = false, name = "cargoID") String cargoID) {
		if (null != cargoID) {
			model.addAttribute("title", cargoService.Map().get("editTitle"));
			model.addAttribute("submitValue",cargoService.Map().get("edit"));
			model.addAttribute("cargo",cargoService.findById(cargoID));
		} else {
			model.addAttribute("title", cargoService.Map().get("addTitle"));
			model.addAttribute("submitValue", cargoService.Map().get("add"));
			model.addAttribute("cargo", new Cargo());
		}
		return "cargoAddEdit";
	}

	@PostMapping("/add")
	public String rutaUpdate(Model model, Cargo cargo){
		cargoService.save(cargo);
		model.addAllAttributes(cargoService.Map());
		model.addAttribute("cargos",cargoService.findAll());
		return "cargos";
	}
}
