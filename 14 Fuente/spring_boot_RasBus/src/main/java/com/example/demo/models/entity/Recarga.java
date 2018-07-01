package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "recarga")
public class Recarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Recarga_ID")
    private Integer recargaID;

    @Column(name = "Monto")
    private double monto;

    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @JoinColumn(name = "Tarjeta_ID", referencedColumnName = "Tarjeta_ID")
    @ManyToOne(optional = false)
    private Tarjeta tarjetaID;
    
    @JoinColumn(name = "TipoRecarga_ID", referencedColumnName = "TipoRecarga_ID")
    @ManyToOne(optional = false)
    private Tiporecarga tipoRecargaID;

    public Recarga() {
    }

    public Recarga(Integer recargaID) {
        this.recargaID = recargaID;
    }

    public Recarga(Integer recargaID, double monto, Date fecha) {
        this.recargaID = recargaID;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Integer getRecargaID() {
        return recargaID;
    }

    public void setRecargaID(Integer recargaID) {
        this.recargaID = recargaID;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Tarjeta getTarjetaID() {
        return tarjetaID;
    }

    public void setTarjetaID(Tarjeta tarjetaID) {
        this.tarjetaID = tarjetaID;
    }

    public Tiporecarga getTipoRecargaID() {
        return tipoRecargaID;
    }

    public void setTipoRecargaID(Tiporecarga tipoRecargaID) {
        this.tipoRecargaID = tipoRecargaID;
    }
}
