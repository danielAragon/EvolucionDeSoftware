package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tiporecarga")
public class Tiporecarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "TipoRecarga_ID")
    private Integer tipoRecargaID;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoRecargaID")
    private Collection<Recarga> recargaCollection;

    public Tiporecarga() {
    }

    public Tiporecarga(Integer tipoRecargaID) {
        this.tipoRecargaID = tipoRecargaID;
    }

    public Tiporecarga(Integer tipoRecargaID, String nombre, String descripcion) {
        this.tipoRecargaID = tipoRecargaID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getTipoRecargaID() {
        return tipoRecargaID;
    }

    public void setTipoRecargaID(Integer tipoRecargaID) {
        this.tipoRecargaID = tipoRecargaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Recarga> getRecargaCollection() {
        return recargaCollection;
    }

    public void setRecargaCollection(Collection<Recarga> recargaCollection) {
        this.recargaCollection = recargaCollection;
    }
}
