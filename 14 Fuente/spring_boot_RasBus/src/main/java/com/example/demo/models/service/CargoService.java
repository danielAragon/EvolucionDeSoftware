package com.example.demo.models.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.ICargoDAO;
import com.example.demo.models.entity.Cargo;
import com.example.demo.models.service.protocol.ICargoService;

@Service
public class CargoService implements ICargoService{

	@Autowired
	ICargoDAO cargoDAO;

	public Map<String, Object> map;

	public CargoService() {
		super();
		map = new HashMap<>();
		map.put("title", "Listado de Cargos");
		map.put("addTitle", "Agregar Cargo");
		map.put("add","Registrar");
		map.put("editTitle","Editar Cargo");
		map.put("edit","Actualizar");
	}

	@Override
	public Collection<Cargo> findAll() {
		return (Collection<Cargo>)cargoDAO.findAll();
	}

	@Override
	public void save(Cargo t) {
		cargoDAO.save(t);
	}

	@Override
	public Optional<Cargo> findById(String t) {
		return cargoDAO.findById(t);
	}

	@Override
	public void deleteById(String t) {
		cargoDAO.deleteById(t);
	}

	@Override
	public java.util.Map<String, Object> Map() {
		// TODO Auto-generated method stub
		return map;
	}
}
