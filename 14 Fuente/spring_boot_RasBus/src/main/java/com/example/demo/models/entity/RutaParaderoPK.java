package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class RutaParaderoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
    @Column(name = "Ruta_ID")
    private String rutaID;
    @Basic(optional = false)
    @Column(name = "Paradero_ID")
    private String paraderoID;

    public RutaParaderoPK() {
    }

    public RutaParaderoPK(String rutaID, String paraderoID) {
        this.rutaID = rutaID;
        this.paraderoID = paraderoID;
    }

    public String getRutaID() {
        return rutaID;
    }

    public void setRutaID(String rutaID) {
        this.rutaID = rutaID;
    }

    public String getParaderoID() {
        return paraderoID;
    }

    public void setParaderoID(String paraderoID) {
        this.paraderoID = paraderoID;
    }
}
