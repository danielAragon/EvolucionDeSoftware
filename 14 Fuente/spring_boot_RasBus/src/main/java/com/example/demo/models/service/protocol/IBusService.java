package com.example.demo.models.service.protocol;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import com.example.demo.models.entity.Bus;

public interface IBusService {
	public Map<String, Object> Map();
	public Collection<Bus> findAll();
	public void save(Bus t);
	public Optional<Bus> findById(String t);
	public void deleteById(String t);
}
