package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estacion_policial")
public class EstacionPolicial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Estacion_ID")
    private Integer estacionID;
    
    @Column(name = "Telefono")
    private int telefono;
    
    @JoinColumn(name = "Distrito_ID", referencedColumnName = "Distrito_ID")
    @ManyToOne(optional = false)
    private Distrito distritoID;

    public EstacionPolicial() {
    }

    public EstacionPolicial(Integer estacionID) {
        this.estacionID = estacionID;
    }

    public EstacionPolicial(Integer estacionID, int telefono) {
        this.estacionID = estacionID;
        this.telefono = telefono;
    }

    public Integer getEstacionID() {
        return estacionID;
    }

    public void setEstacionID(Integer estacionID) {
        this.estacionID = estacionID;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Distrito getDistritoID() {
        return distritoID;
    }

    public void setDistritoID(Distrito distritoID) {
        this.distritoID = distritoID;
    }
    
}
