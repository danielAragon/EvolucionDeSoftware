package com.example.demo.models.entity;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

@Entity
@Table(name = "ruta")
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Ruta_ID")
    private String rutaID;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Horario_Inicio")
    private Time horarioInicio;
    
    @Column(name = "Horario_Fin")
    private Time horarioFin;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruta")
    private Collection<RutaParadero> rutaParaderoCollection;

    public Ruta() {
    }

    public Ruta(String rutaID) {
        this.rutaID = rutaID;
    }

    public Ruta(String rutaID, String nombre) {
        this.rutaID = rutaID;
        this.nombre = nombre;
    }

    public String getRutaID() {
        return rutaID;
    }

    public void setRutaID(String rutaID) {
        this.rutaID = rutaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<RutaParadero> getRutaParaderoCollection() {
        return rutaParaderoCollection;
    }

    public void setRutaParaderoCollection(Collection<RutaParadero> rutaParaderoCollection) {
        this.rutaParaderoCollection = rutaParaderoCollection;
    }

	public Time getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Time horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Time getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(Time horarioFin) {
		this.horarioFin = horarioFin;
	}
    
}

