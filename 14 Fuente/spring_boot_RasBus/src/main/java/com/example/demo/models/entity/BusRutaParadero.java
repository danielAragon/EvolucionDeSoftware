package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bus_ruta_paradero")
public class BusRutaParadero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @JoinColumn(name = "Bus_ID", referencedColumnName = "Bus_ID")
    @ManyToOne(optional = false)
    private Bus busID;
    
    @JoinColumns({
        @JoinColumn(name = "Ruta_ID", referencedColumnName = "Ruta_ID")
        , @JoinColumn(name = "Paradero_ID", referencedColumnName = "Paradero_ID")})
    @ManyToOne(optional = false)
    private RutaParadero rutaParadero;

    
    @Column(name = "Latitud")
    private int latitud;

	@Column(name = "Longitud")
    private int longitud;
    
    public BusRutaParadero() {
    }

    public BusRutaParadero(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Bus getBusID() {
        return busID;
    }

    public void setBusID(Bus busID) {
        this.busID = busID;
    }

    public RutaParadero getRutaParadero() {
        return rutaParadero;
    }

    public void setRutaParadero(RutaParadero rutaParadero) {
        this.rutaParadero = rutaParadero;
    }
    public int getLatitud() {
		return latitud;
	}

	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
}

