package com.example.demo.models.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.entity.Ruta;

public interface IRutaDAO extends JpaRepository<Ruta, String> {
	@Query
	public Collection<Ruta> findByNombre(@Param(value="nombre") String nombre);
}
