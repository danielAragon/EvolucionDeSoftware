package com.example.demo.models.service.protocol;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import com.example.demo.models.entity.Ruta;

public interface IRutaService {
	public Collection<Ruta> findAll();
	public void save(Ruta t);
	public Optional<Ruta> findById(String t);
	public void deleteById(String t);
	public Map<String, Object> Map();
}
