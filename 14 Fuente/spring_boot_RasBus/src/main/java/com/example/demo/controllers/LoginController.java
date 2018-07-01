package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.entity.Persona;
import com.example.demo.models.service.protocol.IPersonaService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	public IPersonaService personaService;
	
	@GetMapping
	public String login(Model model) {
		System.out.println("hello from login controller");
		return "login";
	}
	
	@PostMapping("/signin")
	public String signin(Model model,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		List<Persona> result = personaService.iniciarSesion(username, password);
		
		if(result.size() > 0) {
			model.addAttribute("user","Bienvenido "+username);
			return "redirect:/buses/";
		}
		else {
			return "/login";
		}
	}
}
