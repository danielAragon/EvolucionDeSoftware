package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.entity.Distrito;
import com.example.demo.models.entity.Paradero;
import com.example.demo.models.service.protocol.IParaderoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {

		@Autowired
		public IParaderoService paraderoService;
		
		@RequestMapping(method= RequestMethod.GET,value="api/paraderos")
		public List<Paradero> getParaderos() {
			return paraderoService.findAllParaderos();
		}
		
		@RequestMapping(method=RequestMethod.POST,value="api/paraderos")
		public String setParadero(@RequestParam("paraderoID") String paraderoID,
				@RequestParam("nombre") String nombre,
				@RequestParam("calle") String calle,
				@RequestParam("descripcion") String descripcion,
				@RequestParam("distritoID") Distrito distritoID,
				@RequestParam("latitud") double latitud,
				@RequestParam("longitud") double longitud) {
			Paradero paradero = new Paradero();
			paradero.setParaderoID(paraderoID);
			paradero.setNombre(nombre);
			paradero.setDescripcion(descripcion);
			paradero.setCalle(calle);
			paradero.setDistritoID(distritoID);
			paradero.setLatitud(latitud);
			paradero.setLongitud(longitud);
			
			paraderoService.save(paradero);
			return "Paradero registrado correctamente";
		}
}
