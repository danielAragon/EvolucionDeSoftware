package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cargo_ID")
    private Integer cargoID;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Sueldo")
    private double sueldo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoID")
    private Collection<Trabajador> trabajadorCollection;

    public Cargo() {
    }

    public Cargo(Integer cargoID) {
        this.cargoID = cargoID;
    }

    public Cargo(Integer cargoID, String nombre, double sueldo) {
        this.cargoID = cargoID;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public Integer getCargoID() {
        return cargoID;
    }

    public void setCargoID(Integer cargoID) {
        this.cargoID = cargoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Collection<Trabajador> getTrabajadorCollection() {
        return trabajadorCollection;
    }

    public void setTrabajadorCollection(Collection<Trabajador> trabajadorCollection) {
        this.trabajadorCollection = trabajadorCollection;
    }
    
}
