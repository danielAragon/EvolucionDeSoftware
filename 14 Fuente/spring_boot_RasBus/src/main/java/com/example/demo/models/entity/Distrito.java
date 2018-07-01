package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "distrito")
public class Distrito implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "Distrito_ID")
    private String distritoID;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distritoID")
    private Collection<Paradero> paraderoCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distritoID")
    private Collection<EstacionPolicial> estacionPolicialCollection;

    public Distrito() {
    }

    public Distrito(String distritoID) {
        this.distritoID = distritoID;
    }

    public Distrito(String distritoID, String nombre) {
        this.distritoID = distritoID;
        this.nombre = nombre;
    }

    public String getDistritoID() {
        return distritoID;
    }

    public void setDistritoID(String distritoID) {
        this.distritoID = distritoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Collection<Paradero> getParaderoCollection() {
        return paraderoCollection;
    }

    public void setParaderoCollection(Collection<Paradero> paraderoCollection) {
        this.paraderoCollection = paraderoCollection;
    }
    public Collection<EstacionPolicial> getEstacionPolicialCollection() {
        return estacionPolicialCollection;
    }

    public void setEstacionPolicialCollection(Collection<EstacionPolicial> estacionPolicialCollection) {
        this.estacionPolicialCollection = estacionPolicialCollection;
    }
    
}
