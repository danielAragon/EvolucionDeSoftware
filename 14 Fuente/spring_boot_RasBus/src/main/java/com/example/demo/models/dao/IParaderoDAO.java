package com.example.demo.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.entity.Paradero;

public interface IParaderoDAO extends JpaRepository<Paradero, String>{
	
	@Query(value = "SELECT * FROM Paradero", nativeQuery = true)
	public List<Paradero> findAllParaderos();
}
