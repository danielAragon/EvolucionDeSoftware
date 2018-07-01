package com.example.demo.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.entity.Cargo;

public interface ICargoDAO extends JpaRepository<Cargo, String>{

}
