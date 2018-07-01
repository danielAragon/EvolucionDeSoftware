package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "viaje")
public class Viaje implements Serializable {

    private static final long serialVersionUID = 1L;
	@EmbeddedId
    protected ViajePK viajePK;

    @Column(name = "Precio")
    private double precio;
    
    @JoinColumn(name = "Tarjeta_ID", referencedColumnName = "Tarjeta_ID")
    @ManyToOne(optional = false)
    private Tarjeta tarjetaID;
    
    @JoinColumn(name = "Bus_ID", referencedColumnName = "Bus_ID")
    @ManyToOne(optional = false)
    private Bus busID;

    public Viaje() {
    }

    public Viaje(ViajePK viajePK) {
        this.viajePK = viajePK;
    }

    public Viaje(ViajePK viajePK, double precio) {
        this.viajePK = viajePK;
        this.precio = precio;
    }

    public Viaje(long viajeID, Date fecha) {
        this.viajePK = new ViajePK(viajeID, fecha);
    }

    public ViajePK getViajePK() {
        return viajePK;
    }

    public void setViajePK(ViajePK viajePK) {
        this.viajePK = viajePK;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Tarjeta getTarjetaID() {
        return tarjetaID;
    }

    public void setTarjetaID(Tarjeta tarjetaID) {
        this.tarjetaID = tarjetaID;
    }

    public Bus getBusID() {
        return busID;
    }

    public void setBusID(Bus busID) {
        this.busID = busID;
    }
    
}
