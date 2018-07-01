package com.example.demo.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.entity.Bus;

public interface IBusDAO extends JpaRepository<Bus, String>{

}
