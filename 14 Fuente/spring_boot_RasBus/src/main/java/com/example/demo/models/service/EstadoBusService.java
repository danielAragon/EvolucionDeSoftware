package com.example.demo.models.service;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.IEstadoBusDAO;
import com.example.demo.models.entity.EstadoBus;
import com.example.demo.models.entity.EstadoBusPK;
import com.example.demo.models.service.protocol.IEstadoBusService;

@Service
public class EstadoBusService implements IEstadoBusService {
	
	@Autowired
	IEstadoBusDAO estadoDAO;
	
	public Map<String, Object> map;
	
	public EstadoBusService() {
		map = new HashMap<>();
		map.put("titulo", "Lista de Estados de Los Buses");
	}
	@Override
	public Collection<EstadoBus> findAll() {
		return estadoDAO.findAll();
	}

	@Override
	public void save(EstadoBus t) {
		estadoDAO.save(t);
	}
	@Override
	public Map<String, Object> Map() {
		return map;
	}
//	@Override
//	public Optional<EstadoBus> findOne(int t) {
//		return estadoDAO.findByEstadoID(t);
//	}
//
	@Override
	public void delete(EstadoBusPK t) {
		estadoDAO.deleteById(t);
	}

//	@Override
//	public Collection<EstadoBus> filterByDate(Date date) {
//		return estadoDAO.findByFecha(date);
//	}
//
//	@Override
//	public Collection<EstadoBus> filterByRangeDate(Date min, Date max) {
//		return estadoDAO.findAll().stream()
//				.filter(x -> x.getEstadoBusPK().getFecha().after(min) && x.getEstadoBusPK().getFecha().before(max))
//				.collect(Collectors.toList());
//	}
//
//	@Override
//	public Collection<EstadoBus> filterByRoute(String ruta) {
//		return estadoDAO.findByDireccion(ruta);
//	}
//
//	@Override
//	public Collection<EstadoBus> filterByBusID(String BusID) {
//		return estadoDAO.findByBusID(BusID);
//	}
//
//	@Override
//	public Collection<EstadoBus> filterByBusIDandDate(String BusID, Date fecha) {
//		return estadoDAO.findByBusIDandDate(BusID, fecha);
//	}
//
//	@Override
//	public Collection<EstadoBus> filterByBusIDandRangeDate(String BusID, Date Fmin, Date Fmax) {
//		return estadoDAO.findByBusIDandRangeDate(BusID, Fmin, Fmax);
//	}

}
