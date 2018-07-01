package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class ViajePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Viaje_ID")
    private long viajeID;
	
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public ViajePK() {
    }

    public ViajePK(long viajeID, Date fecha) {
        this.viajeID = viajeID;
        this.fecha = fecha;
    }

    public long getViajeID() {
        return viajeID;
    }

    public void setViajeID(long viajeID) {
        this.viajeID = viajeID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
