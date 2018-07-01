package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "incidente")
public class Incidente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Prioridad")
    private int prioridad;
    
    @JoinColumns({
        @JoinColumn(name = "Bus_ID", referencedColumnName = "Estado_ID")
        , @JoinColumn(name = "Fecha", referencedColumnName = "Fecha")})
    @ManyToOne(optional = false)
    private EstadoBus estadoBus;

    public Incidente() {
    }

    public Incidente(Integer id) {
        this.id = id;
    }

    public Incidente(Integer id, String descripcion, int prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public EstadoBus getEstadoBus() {
        return estadoBus;
    }

    public void setEstadoBus(EstadoBus estadoBus) {
        this.estadoBus = estadoBus;
    }

}
