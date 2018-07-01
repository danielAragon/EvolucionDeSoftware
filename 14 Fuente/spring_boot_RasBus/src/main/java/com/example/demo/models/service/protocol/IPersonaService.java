package com.example.demo.models.service.protocol;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.models.entity.Persona;

public interface IPersonaService {
	public Map<String, Object> Map();
	public Collection<Persona> findAll();
	public void save(Persona t);
	public Optional<Persona> findById(String t);
	public void deleteById(String t);
	public List<Persona> iniciarSesion(String username, String password);
}
