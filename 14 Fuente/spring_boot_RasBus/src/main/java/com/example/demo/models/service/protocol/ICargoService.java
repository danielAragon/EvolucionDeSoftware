package com.example.demo.models.service.protocol;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import com.example.demo.models.entity.Cargo;

public interface ICargoService {
	public Map<String, Object> Map();
	public Collection<Cargo> findAll();
	public void save(Cargo t);
	public Optional<Cargo> findById(String t);
	public void deleteById(String t);

}
