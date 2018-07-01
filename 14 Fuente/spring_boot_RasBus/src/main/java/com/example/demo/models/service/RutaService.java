package com.example.demo.models.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.IRutaDAO;
import com.example.demo.models.entity.Ruta;
import com.example.demo.models.service.protocol.IRutaService;

@Service
public class RutaService implements IRutaService {

	@Autowired
	IRutaDAO rutaDAO;
	
	public Map<String, Object> map;
	
	public RutaService() {
		super();
		map = new HashMap<>();
		map.put("title", "Listado de Rutas");
		map.put("addTitle","Agregar Ruta");
		map.put("add","Registrar");
		map.put("editTitle","Editar Ruta");
		map.put("edit","Actualizar");
	}

	@Override
	public Collection<Ruta> findAll() {
		/*Collection<Ruta> rut = (Collection<Ruta>)(rutaDAO.findAll());
		Stream<Ruta> rutfilter= rut.stream().filter(a -> a.getNombre().contains("df"));
		return rutfilter.collect(Collectors.toList());*/
		return (Collection<Ruta>)(rutaDAO.findAll());
	}

	@Override
	public void save(Ruta t) {
		// TODO Auto-generated method stub
		rutaDAO.save(t);
	}

	@Override
	public Optional<Ruta> findById(String t) {
		// TODO Auto-generated method stub
		return rutaDAO.findById(t);
	}
	
	@Override
	public void deleteById(String t) {
		// TODO Auto-generated method stub
		rutaDAO.deleteById(t);
	}
	
	@Override
	public Map<String, Object> Map(){
		return map;
	}

}
