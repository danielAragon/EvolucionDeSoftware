package com.example.demo.models.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.ITrabajadorDAO;
import com.example.demo.models.entity.Trabajador;
import com.example.demo.models.service.protocol.ITrabajadorService;

@Service
public class TrabajadorService implements ITrabajadorService{

	@Autowired
	ITrabajadorDAO trabajadorDAO;

	public Map<String, Object> map;

	public TrabajadorService() {
		super();
		map = new HashMap<>();
		map.put("title","Listado de Trabajadores");
		map.put("addTitle","Agregar Trabajador");
		map.put("add","Registrar");
		map.put("editTitle","Editar Trabajador");
		map.put("edit","Actualizar");
	}

	@Override
	public Collection<Trabajador> findAll() {
		return (Collection<Trabajador>)trabajadorDAO.findAll();
	}

	@Override
	public void save(Trabajador t) {
		trabajadorDAO.save(t);
	}

	@Override
	public Optional<Trabajador> findById(String t) {
		return trabajadorDAO.findById(t);
	}

	@Override
	public void deleteById(String t) {
		trabajadorDAO.deleteById(t);
	}

	@Override
	public java.util.Map<String, Object> Map() {
		// TODO Auto-generated method stub
		return map;
	}
}
