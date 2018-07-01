package com.example.demo.models.service.protocol;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import com.example.demo.models.entity.Trabajador;

public interface ITrabajadorService {
	public Map<String, Object> Map();
	public Collection<Trabajador> findAll();
	public void save(Trabajador t);
	public Optional<Trabajador> findById(String t);
	public void deleteById(String t);
}
