package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.entity.Paradero;
import com.example.demo.models.service.protocol.IParaderoService;

@Controller
@RequestMapping("/paraderos")
public class ParaderoController {
	@Autowired
	public IParaderoService paraderoService;
	
	@GetMapping
	public String listar(Model model) {
		model.addAllAttributes(paraderoService.Map());
		model.addAttribute("paraderos", paraderoService.findAll());
		return "paraderos";
	}
	
	@GetMapping({"/add","/edit/{paradero_id}"})
    public String paraderoFindOne(Model model, @PathVariable(required = false, name = "paradero_id") String paradero_id) {
        if (null != paradero_id) {
            model.addAttribute("paradero", paraderoService.findById(paradero_id));
        } else {
            model.addAttribute("paradero", new Paradero());
        }
        return "paraderoAddEdit";
    }
	
	@PostMapping("/paraderoAddEdit")
	public String paraderoUpdate(Model model, Paradero paradero) {
		System.out.println(paradero.getParaderoID());
		paraderoService.save(paradero);
		model.addAttribute("paraderos", paraderoService.findAll());
		return "paraderos";
	}
}
