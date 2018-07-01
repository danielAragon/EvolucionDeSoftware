package com.example.demo.models.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.entity.RutaParadero;
import com.example.demo.models.entity.RutaParaderoPK;

public interface IRutaParaderoDAO extends JpaRepository<RutaParadero, RutaParaderoPK> {

//	public Collection<RutaParadero> findParaderosByRuta(String rutaID);
	
//	@Query("select rp from RutaParadero rp where rp.nombre like %?1%")
//	public List<RutaParadero> findByNombre(String term);
//	public Collection<RutaParadero> findParaderosByRuta(String rutaID);
//	public Collection<RutaParadero> findParaderosByRuta(String rutaID) {
//		// TODO Auto-generated method stub
//		return findAll().stream().filter(x -> x.getRutaParaderoPK().getRutaID() == rutaID).collect(Collectors.toList());
//	}
}
