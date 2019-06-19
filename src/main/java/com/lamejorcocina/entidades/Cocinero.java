/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamejorcocina.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres Gamba
 */
@Entity
@Table(name = "cocinero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cocinero.findAll", query = "SELECT c FROM Cocinero c"),
    @NamedQuery(name = "Cocinero.findByIdCocinero", query = "SELECT c FROM Cocinero c WHERE c.idCocinero = :idCocinero"),
    @NamedQuery(name = "Cocinero.findByNombre", query = "SELECT c FROM Cocinero c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cocinero.findByApellido1", query = "SELECT c FROM Cocinero c WHERE c.apellido1 = :apellido1"),
    @NamedQuery(name = "Cocinero.findByApellido2", query = "SELECT c FROM Cocinero c WHERE c.apellido2 = :apellido2")})
public class Cocinero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdCocinero")
    private Long idCocinero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Apellido1")
    private String apellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Apellido2")
    private String apellido2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCocinero")
    private List<Detallefactura> detallefacturaList;

    public Cocinero() {
    }

    public Cocinero(Long idCocinero) {
        this.idCocinero = idCocinero;
    }

    public Cocinero(Long idCocinero, String nombre, String apellido1, String apellido2) {
        this.idCocinero = idCocinero;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public Long getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(Long idCocinero) {
        this.idCocinero = idCocinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @XmlTransient
    public List<Detallefactura> getDetallefacturaList() {
        return detallefacturaList;
    }

    public void setDetallefacturaList(List<Detallefactura> detallefacturaList) {
        this.detallefacturaList = detallefacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCocinero != null ? idCocinero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cocinero)) {
            return false;
        }
        Cocinero other = (Cocinero) object;
        if ((this.idCocinero == null && other.idCocinero != null) || (this.idCocinero != null && !this.idCocinero.equals(other.idCocinero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lamejorcocina.entidades.Cocinero[ idCocinero=" + idCocinero + " ]";
    }
    
}
