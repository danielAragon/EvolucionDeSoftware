package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paradero")
public class Paradero implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "Paradero_ID")
    private String paraderoID;

    @Column(name = "Nombre")
    private String nombre;

	@Column(name = "Calle")
    private String calle;

    @Column(name = "Descripcion")
    private String descripcion;
    
    @JoinColumn(name = "Distrito_ID", referencedColumnName = "Distrito_ID")
    @ManyToOne(optional = false)
    private Distrito distritoID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paradero")
    private Collection<RutaParadero> rutaParaderoCollection;
    
    @Column(name = "Latitud")
    private double latitud;
    
    @Column(name = "Longitud")
    private double longitud;

    public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public Paradero() {
    }

    public Paradero(String paraderoID) {
        this.paraderoID = paraderoID;
    }

    public Paradero(String paraderoID, String calle, String provincia, String descripcion) {
        this.paraderoID = paraderoID;
        this.calle = calle;
        this.descripcion = descripcion;
    }

    public String getParaderoID() {
        return paraderoID;
    }

    public void setParaderoID(String paraderoID) {
        this.paraderoID = paraderoID;
    }
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Distrito getDistritoID() {
        return distritoID;
    }

    public void setDistritoID(Distrito distritoID) {
        this.distritoID = distritoID;
    }

    public Collection<RutaParadero> getRutaParaderoCollection() {
        return rutaParaderoCollection;
    }

    public void setRutaParaderoCollection(Collection<RutaParadero> rutaParaderoCollection) {
        this.rutaParaderoCollection = rutaParaderoCollection;
    }
    
 
}
