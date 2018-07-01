package com.example.demo.models.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.IPersonaDAO;
import com.example.demo.models.entity.Persona;
import com.example.demo.models.service.protocol.IPersonaService;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	IPersonaDAO personaDAO;

	public Map<String, Object> map;

	public PersonaService() {
		super();
		map = new HashMap<>();
		map.put("title","Listado de Personas");
		map.put("addTitle","Agregar Persona");
		map.put("add","Registrar");
		map.put("editTitle","Editar Persona");
		map.put("edit","Actualizar");
	}

	@Override
	public Collection<Persona> findAll() {
		return (Collection<Persona>)personaDAO.findAll();
	}

	@Override
	public void save(Persona t) {
		personaDAO.save(t);
	}

	@Override
	public Optional<Persona> findById(String t) {
		return personaDAO.findById(t);
	}

	@Override
	public void deleteById(String t) {
		personaDAO.deleteById(t);
	}

	@Override
	public java.util.Map<String, Object> Map() {
		return map;
	}
	
	@Override
	public List<Persona> iniciarSesion(String username, String password) {
		return personaDAO.inicioSesion(username, password);
	}

}
