package com.example.demo.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.entity.EstadoBus;
import com.example.demo.models.entity.EstadoBusPK;

@Repository
public interface IEstadoBusDAO extends JpaRepository<EstadoBus, EstadoBusPK>{
	//@Query
	//public Optional<EstadoBus> findByEstadoID(@Param(value = "estadoID") Integer estadoID);
	//public Collection<EstadoBus> findByVelocidad(@Param(value = "velocidad") float velocidad);
	//public Collection<EstadoBus> findByCantPasajeros(@Param(value = "cantPasajeros") int cantPasajeros);
	//public Collection<EstadoBus> findByFecha(@Param(value = "fecha") Date fecha);
	//public Collection<EstadoBus> findByGasolinaDisponible(@Param(value = "gasolinaDisponible") Integer gasolinaDisponible);
	//public Collection<EstadoBus> findByTemperaturaMotor(@Param(value = "temperaturaMotor") Float temperaturaMotor);
	//public Collection<EstadoBus> findByDireccion(@Param(value = "direccion") String direccion);
	//public Collection<EstadoBus> findByBateria(@Param(value = "bateria") Integer bateria);
	//public Collection<EstadoBus> findByBusID(@Param(value = "BusID") String BusID);
	//public Collection<EstadoBus> findByBusIDandDate(@Param(value = "BusID") String BusID, @Param(value = "fecha") Date fecha);
	//public Collection<EstadoBus> findByBusIDandRangeDate(@Param(value = "BusID") String BusID, @Param(value = "Fmin") Date Fmin, @Param(value = "Fmax") Date Fmax);
}
