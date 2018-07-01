package com.example.demo.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.entity.Persona;

public interface IPersonaDAO extends JpaRepository<Persona, String>{

	@Query(value = "SELECT * FROM Persona WHERE username = :username AND"
			+ " password = :password", nativeQuery = true)
	public List<Persona> inicioSesion(@Param("username") String username, @Param("password") String password);
	
}
