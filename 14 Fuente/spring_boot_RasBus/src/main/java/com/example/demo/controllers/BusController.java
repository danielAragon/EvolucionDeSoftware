package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.entity.Bus;
import com.example.demo.models.service.protocol.IBusService;

@Controller
@RequestMapping("/buses")
public class BusController {

	@Autowired
	public IBusService busService;
	
	@GetMapping
	public String listar(Model model) {
		model.addAllAttributes(busService.Map());
		model.addAttribute("buses",busService.findAll());
		return "buses";
	}
	@GetMapping({"/add","/edit/{busID}"})
	public String busAddEdit(Model model, @PathVariable(required = false, name = "busID") String busID) {
		if (null != busID) {
			model.addAttribute("title", busService.Map().get("editTitle"));
			model.addAttribute("submitValue", busService.Map().get("edit"));
			model.addAttribute("bus", busService.findById(busID));
		} else {
			model.addAttribute("title", busService.Map().get("addTitle"));
			model.addAttribute("submitValue", busService.Map().get("add"));
			model.addAttribute("bus", new Bus());
		}
		return "busAddEdit";
	}
	@PostMapping("/add")
	public String rutaUpdate(Model model, Bus bus) {
		busService.save(bus);
		model.addAllAttributes(busService.Map());
		model.addAttribute("buses", busService.findAll());
		return "buses";
	}
}
