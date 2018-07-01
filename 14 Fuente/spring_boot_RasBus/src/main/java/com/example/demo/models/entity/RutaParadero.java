package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ruta_paradero")
public class RutaParadero implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@EmbeddedId
    protected RutaParaderoPK rutaParaderoPK;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutaParadero")
    private Collection<BusRutaParadero> busRutaParaderoCollection;
    
    @JoinColumn(name = "Paradero_ID", referencedColumnName = "Paradero_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paradero paradero;
    
    @JoinColumn(name = "Ruta_ID", referencedColumnName = "Ruta_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ruta ruta;

    public RutaParadero() {
    }

    public RutaParadero(RutaParaderoPK rutaParaderoPK) {
        this.rutaParaderoPK = rutaParaderoPK;
    }

    public RutaParadero(String rutaID, String paraderoID) {
        this.rutaParaderoPK = new RutaParaderoPK(rutaID, paraderoID);
    }

    public RutaParaderoPK getRutaParaderoPK() {
        return rutaParaderoPK;
    }

    public void setRutaParaderoPK(RutaParaderoPK rutaParaderoPK) {
        this.rutaParaderoPK = rutaParaderoPK;
    }

    public Collection<BusRutaParadero> getBusRutaParaderoCollection() {
        return busRutaParaderoCollection;
    }

    public void setBusRutaParaderoCollection(Collection<BusRutaParadero> busRutaParaderoCollection) {
        this.busRutaParaderoCollection = busRutaParaderoCollection;
    }

    public Paradero getParadero() {
        return paradero;
    }

    public void setParadero(Paradero paradero) {
        this.paradero = paradero;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
}
