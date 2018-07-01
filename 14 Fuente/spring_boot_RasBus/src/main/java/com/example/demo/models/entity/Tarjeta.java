package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tarjeta")
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Tarjeta_ID")
    private Integer tarjetaID;

    @Column(name = "Saldo")
    private double saldo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarjetaID")
    private Collection<Viaje> viajeCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarjetaID")
    private Collection<Recarga> recargaCollection;
    
    @JoinColumn(name = "Pasajero_ID", referencedColumnName = "Pasajero_ID")
    @ManyToOne
    private Pasajero pasajeroID;

    public Tarjeta() {
    }

    public Tarjeta(Integer tarjetaID) {
        this.tarjetaID = tarjetaID;
    }

    public Tarjeta(Integer tarjetaID, double saldo) {
        this.tarjetaID = tarjetaID;
        this.saldo = saldo;
    }

    public Integer getTarjetaID() {
        return tarjetaID;
    }

    public void setTarjetaID(Integer tarjetaID) {
        this.tarjetaID = tarjetaID;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Collection<Viaje> getViajeCollection() {
        return viajeCollection;
    }

    public void setViajeCollection(Collection<Viaje> viajeCollection) {
        this.viajeCollection = viajeCollection;
    }

    public Collection<Recarga> getRecargaCollection() {
        return recargaCollection;
    }

    public void setRecargaCollection(Collection<Recarga> recargaCollection) {
        this.recargaCollection = recargaCollection;
    }

    public Pasajero getPasajeroID() {
        return pasajeroID;
    }

    public void setPasajeroID(Pasajero pasajeroID) {
        this.pasajeroID = pasajeroID;
    }
    
}
