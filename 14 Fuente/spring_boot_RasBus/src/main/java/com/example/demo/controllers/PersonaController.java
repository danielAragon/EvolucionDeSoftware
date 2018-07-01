package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.entity.Persona;
import com.example.demo.models.service.protocol.IPersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	public IPersonaService personaService;
	
	@GetMapping
	public String listar(Model model) {
		model.addAllAttributes(personaService.Map());
		model.addAttribute("personas",personaService.findAll());
		return "personas";
	}
	@GetMapping({"/add","/edit/{personaID}"})
	public String personaAddEdit(Model model, @PathVariable(required = false, name = "personaID") String personaID) {
		if (null != personaID) {
			model.addAttribute("title", personaService.Map().get("editTitle"));
			model.addAttribute("submitValue", personaService.Map().get("edit"));
			model.addAttribute("persona", personaService.findById(personaID));
		} else {
			model.addAttribute("title", personaService.Map().get("addTitle"));
			model.addAttribute("submitValue", personaService.Map().get("add"));
			model.addAttribute("persona", new Persona());
		}
		return "personaAddEdit";
	}
	@PostMapping("/add")
	public String personaUpdate(Model model, Persona persona) {
		personaService.save(persona);
		model.addAllAttributes(personaService.Map());
		model.addAttribute("personas", personaService.findAll());
		return "redirect:/personas/";
	}
}
