package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "trabajador")
public class Trabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Trabajador_ID")
    private Integer trabajadorID;

    @Column(name = "Fecha_Contratacion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaContratacion;
    
    @Column(name = "Fecha_FinContrato")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinContrato;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajadorID")
    private Collection<EstadoBus> estadoBusCollection;
    
    @JoinColumn(name = "Cargo_ID", referencedColumnName = "Cargo_ID")
    @ManyToOne(optional = false)
    private Cargo cargoID;
    
    @JoinColumn(name = "Trabajador_ID", referencedColumnName = "Persona_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    
    @OneToMany(mappedBy = "reportsTo")
    private Collection<Trabajador> trabajadorCollection;
    
    @JoinColumn(name = "Reports_To", referencedColumnName = "Trabajador_ID")
    @ManyToOne
    private Trabajador reportsTo;

    public Trabajador() {
    }

    public Trabajador(Integer trabajadorID) {
        this.trabajadorID = trabajadorID;
    }

    public Trabajador(Integer trabajadorID, Date fechaContratacion) {
        this.trabajadorID = trabajadorID;
        this.fechaContratacion = fechaContratacion;
    }

    public Integer getTrabajadorID() {
        return trabajadorID;
    }

    public void setTrabajadorID(Integer trabajadorID) {
        this.trabajadorID = trabajadorID;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Date getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public Collection<EstadoBus> getEstadoBusCollection() {
        return estadoBusCollection;
    }

    public void setEstadoBusCollection(Collection<EstadoBus> estadoBusCollection) {
        this.estadoBusCollection = estadoBusCollection;
    }

    public Cargo getCargoID() {
        return cargoID;
    }

    public void setCargoID(Cargo cargoID) {
        this.cargoID = cargoID;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Collection<Trabajador> getTrabajadorCollection() {
        return trabajadorCollection;
    }

    public void setTrabajadorCollection(Collection<Trabajador> trabajadorCollection) {
        this.trabajadorCollection = trabajadorCollection;
    }

    public Trabajador getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Trabajador reportsTo) {
        this.reportsTo = reportsTo;
    }
    
}
