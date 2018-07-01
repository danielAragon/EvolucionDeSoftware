package com.example.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "bus")
public class Bus implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "Bus_ID")
    private String busID;

    @Column(name = "Matricula")
    private String matricula;

    @Column(name = "Cant_Asiento")
    private int cantAsiento;

    @Column(name = "Fecha_Compra")
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCompra;

    @Column(name = "Foto")
    private String foto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busID")
    private Collection<EstadoBus> estadoBusCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busID")
    private Collection<BusRutaParadero> busRutaParaderoCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busID")
    private Collection<Viaje> viajeCollection;

    public Bus() {
    }

    public String getBusID() {
        return busID;
    }

    public void setBusID(String busID) {
        this.busID = busID;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCantAsiento() {
        return cantAsiento;
    }

    public void setCantAsiento(int cantAsiento) {
        this.cantAsiento = cantAsiento;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Collection<EstadoBus> getEstadoBusCollection() {
        return estadoBusCollection;
    }

    public void setEstadoBusCollection(Collection<EstadoBus> estadoBusCollection) {
        this.estadoBusCollection = estadoBusCollection;
    }
    
    public Collection<BusRutaParadero> getBusRutaParaderoCollection() {
        return busRutaParaderoCollection;
    }

    public void setBusRutaParaderoCollection(Collection<BusRutaParadero> busRutaParaderoCollection) {
        this.busRutaParaderoCollection = busRutaParaderoCollection;
    }

    public Collection<Viaje> getViajeCollection() {
        return viajeCollection;
    }

    public void setViajeCollection(Collection<Viaje> viajeCollection) {
        this.viajeCollection = viajeCollection;
    }
}
