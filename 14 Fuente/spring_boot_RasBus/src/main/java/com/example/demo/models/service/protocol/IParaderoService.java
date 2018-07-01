package com.example.demo.models.service.protocol;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.models.entity.Paradero;
import com.example.demo.models.service.viewmodel.RutaParaderoViewModel;;

public interface IParaderoService {
	public Collection<Paradero> findAll();
	public void save(Paradero t);
	public Optional<Paradero> findById(String t);
	public void deleteById(String t);
	public Map<String, Object> Map();
	public List<Paradero> findAllParaderos();
}
