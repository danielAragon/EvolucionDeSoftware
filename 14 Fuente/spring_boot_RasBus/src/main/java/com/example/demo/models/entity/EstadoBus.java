package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "estado_bus")
public class EstadoBus implements Serializable {

    private static final long serialVersionUID = 1L;
	@EmbeddedId
    protected EstadoBusPK estadoBusPK;
    
	@Column(name = "Velocidad")
    private float velocidad;
    
    @Column(name = "Cant_Pasajeros")
    private int cantPasajeros;
    
    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "TemperaturaMotor")
    private float temperaturaMotor;
    
    @Column(name = "GasolinaDisponible")
    private int gasolinaDisponible;
    
    @Column(name = "Bateria")
    private int bateria;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoBus")
    private Collection<Incidente> incidenteCollection;
    
    @JoinColumn(name = "Bus_ID", referencedColumnName = "Bus_ID")
    @ManyToOne(optional = false)
    private Bus busID;
    
    @JoinColumn(name = "Trabajador_ID", referencedColumnName = "Trabajador_ID")
    @ManyToOne(optional = false)
    private Trabajador trabajadorID;

    public EstadoBus() {
    }
    
    public EstadoBus(EstadoBusPK estadoBusPK) {
        this.estadoBusPK = estadoBusPK;
    }

    public EstadoBus(EstadoBusPK estadoBusPK, float velocidad, int cantPasajeros, String direccion) {
        this.estadoBusPK = estadoBusPK;
        this.velocidad = velocidad;
        this.cantPasajeros = cantPasajeros;
        this.direccion = direccion;
    }

    public EstadoBus(int estadoID, Date fecha) {
        this.estadoBusPK = new EstadoBusPK(estadoID, fecha);
    }

    public EstadoBusPK getEstadoBusPK() {
        return estadoBusPK;
    }

    public void setEstadoBusPK(EstadoBusPK estadoBusPK) {
        this.estadoBusPK = estadoBusPK;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Float getTemperaturaMotor() {
        return temperaturaMotor;
    }

    public void setTemperaturaMotor(Float temperaturaMotor) {
        this.temperaturaMotor = temperaturaMotor;
    }

    public Integer getGasolinaDisponible() {
        return gasolinaDisponible;
    }

    public void setGasolinaDisponible(Integer gasolinaDisponible) {
        this.gasolinaDisponible = gasolinaDisponible;
    }

    public Integer getBateria() {
        return bateria;
    }

    public void setBateria(Integer bateria) {
        this.bateria = bateria;
    }

    public Collection<Incidente> getIncidenteCollection() {
        return incidenteCollection;
    }

    public void setIncidenteCollection(Collection<Incidente> incidenteCollection) {
        this.incidenteCollection = incidenteCollection;
    }

    public Bus getBusID() {
        return busID;
    }

    public void setBusID(Bus busID) {
        this.busID = busID;
    }

    public Trabajador getTrabajadorID() {
        return trabajadorID;
    }

    public void setTrabajadorID(Trabajador trabajadorID) {
        this.trabajadorID = trabajadorID;
    }

}
