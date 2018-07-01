package com.example.demo.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.entity.Trabajador;

public interface ITrabajadorDAO extends JpaRepository<Trabajador, String>{

}
