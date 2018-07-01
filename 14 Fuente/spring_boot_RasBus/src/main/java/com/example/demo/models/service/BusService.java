package com.example.demo.models.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.IBusDAO;
import com.example.demo.models.entity.Bus;
import com.example.demo.models.service.protocol.IBusService;

@Service
public class BusService implements IBusService {
	
	@Autowired
	IBusDAO busDAO;

	public Map<String, Object> map;

	public BusService() {
		super();
		map = new HashMap<>();
		map.put("title", "Listado de Buses");
		map.put("addTitle","Agregar Bus");
		map.put("add","Registrar");
		map.put("editTitle","Editar Bus");
		map.put("edit","Actualizar");
	}
	
	@Override
	public Collection<Bus> findAll() {
		return (Collection<Bus>)busDAO.findAll();
	}

	@Override
	public void save(Bus t) {
		busDAO.save(t);
	}

	@Override
	public Optional<Bus> findById(String t) {
		return busDAO.findById(t);
	}

	@Override
	public void deleteById(String t) {
		busDAO.deleteById(t);
	}

	@Override
	public java.util.Map<String, Object> Map() {
		// TODO Auto-generated method stub
		return map;
	}

}
