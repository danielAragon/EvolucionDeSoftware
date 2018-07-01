package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pasajero")
public class Pasajero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pasajero_ID")
    private Integer pasajeroID;

    @Column(name = "Fecha_Caducidad_Tarjeta")
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidadTarjeta;

    @Column(name = "TieneSeguro")
    private boolean tieneSeguro;

    @Column(name = "SeguroDescripcion")
    private String seguroDescripcion;
    
    @JoinColumn(name = "Pasajero_ID", referencedColumnName = "Persona_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    
    @OneToMany(mappedBy = "pasajeroID")
    private Collection<Tarjeta> tarjetaCollection;

    public Pasajero() {
    }

    public Pasajero(Integer pasajeroID) {
        this.pasajeroID = pasajeroID;
    }

    public Pasajero(Integer pasajeroID, Date fechaCaducidadTarjeta, boolean tieneSeguro, String seguroDescripcion) {
        this.pasajeroID = pasajeroID;
        this.fechaCaducidadTarjeta = fechaCaducidadTarjeta;
        this.tieneSeguro = tieneSeguro;
        this.seguroDescripcion = seguroDescripcion;
    }

    public Integer getPasajeroID() {
        return pasajeroID;
    }

    public void setPasajeroID(Integer pasajeroID) {
        this.pasajeroID = pasajeroID;
    }

    public Date getFechaCaducidadTarjeta() {
        return fechaCaducidadTarjeta;
    }

    public void setFechaCaducidadTarjeta(Date fechaCaducidadTarjeta) {
        this.fechaCaducidadTarjeta = fechaCaducidadTarjeta;
    }

    public boolean getTieneSeguro() {
        return tieneSeguro;
    }

    public void setTieneSeguro(boolean tieneSeguro) {
        this.tieneSeguro = tieneSeguro;
    }

    public String getSeguroDescripcion() {
        return seguroDescripcion;
    }

    public void setSeguroDescripcion(String seguroDescripcion) {
        this.seguroDescripcion = seguroDescripcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Collection<Tarjeta> getTarjetaCollection() {
        return tarjetaCollection;
    }

    public void setTarjetaCollection(Collection<Tarjeta> tarjetaCollection) {
        this.tarjetaCollection = tarjetaCollection;
    }
    
}
