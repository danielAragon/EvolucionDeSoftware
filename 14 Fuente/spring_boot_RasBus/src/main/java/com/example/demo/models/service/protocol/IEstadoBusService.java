package com.example.demo.models.service.protocol;

import java.util.Collection;
import java.util.Map;

import com.example.demo.models.entity.EstadoBus;
import com.example.demo.models.entity.EstadoBusPK;

public interface IEstadoBusService {
	public Collection<EstadoBus> findAll();
	public void save(EstadoBus t);
//	public Optional<EstadoBus> findOne(int t);
	public void delete(EstadoBusPK t);
//	public Collection<EstadoBus> filterByDate(Date date);
//	public Collection<EstadoBus> filterByRangeDate(Date min, Date max);
//	public Collection<EstadoBus> filterByRoute(String ruta);
//	public Collection<EstadoBus> filterByBusID(String BusID);
//	public Collection<EstadoBus> filterByBusIDandDate(String BusID, Date fecha);
//	public Collection<EstadoBus> filterByBusIDandRangeDate(String BusID, Date Fmin, Date Fmax);
	public Map<String, Object> Map();

}
