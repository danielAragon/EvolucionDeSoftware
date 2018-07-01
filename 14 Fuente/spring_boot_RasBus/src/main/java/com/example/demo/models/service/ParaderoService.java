package com.example.demo.models.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.IParaderoDAO;
import com.example.demo.models.dao.IRutaDAO;
import com.example.demo.models.dao.IRutaParaderoDAO;
import com.example.demo.models.entity.Paradero;
import com.example.demo.models.service.protocol.IParaderoService;

@Service
public class ParaderoService implements IParaderoService {

	@Autowired
	IParaderoDAO paraderoDAO;
	
	@Autowired
	IRutaParaderoDAO rutaParaderoDAO;
	
	@Autowired
	IRutaDAO rutaDAO;
	
	public Map<String, Object> map;
	
	public ParaderoService() {
		super();
		map = new HashMap<>();
		map.put("title", "Listado de Paraderos");
		map.put("addTitle","Agregar Paradero");
		map.put("add","Registrar");
		map.put("editTitle","Editar Paradero");
		map.put("edit","Actualizar");	}
	
	@Override
	public Collection<Paradero> findAll() {
		// TODO Auto-generated method stub
		return paraderoDAO.findAll();
	}
	
	@Override
	public void save(Paradero t) {
		// TODO Auto-generated method stub
		paraderoDAO.save(t);
	}

	@Override
	public Optional<Paradero> findById(String t) {
		// TODO Auto-generated method stub
		return paraderoDAO.findById(t);
	}

	@Override
	public void deleteById(String t) {
		// TODO Auto-generated method stub
		paraderoDAO.deleteById(t);
	}

	@Override
	public java.util.Map<String, Object> Map() {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public List<Paradero> findAllParaderos(){
		return paraderoDAO.findAllParaderos();
	}
}
