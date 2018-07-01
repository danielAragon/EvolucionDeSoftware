package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mapa")
public class MapaController {
	
	@GetMapping
	public String mostrar(Model model) {
		return "rasbusMap";
	}
}
