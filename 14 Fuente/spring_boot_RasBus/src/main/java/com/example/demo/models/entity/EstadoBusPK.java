package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class EstadoBusPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "Estado_ID")
    private int estadoID;
    
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public EstadoBusPK(int estadoID, Date fecha) {
        this.estadoID = estadoID;
        this.fecha = fecha;
    }

    public int getEstadoID() {
        return estadoID;
    }

    public void setEstadoID(int estadoID) {
        this.estadoID = estadoID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
