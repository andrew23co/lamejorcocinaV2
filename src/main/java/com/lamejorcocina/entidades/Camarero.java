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
@Table(name = "camarero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camarero.findAll", query = "SELECT c FROM Camarero c"),
    @NamedQuery(name = "Camarero.findByIdCamarero", query = "SELECT c FROM Camarero c WHERE c.idCamarero = :idCamarero"),
    @NamedQuery(name = "Camarero.findByNombre", query = "SELECT c FROM Camarero c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Camarero.findByApellido1", query = "SELECT c FROM Camarero c WHERE c.apellido1 = :apellido1"),
    @NamedQuery(name = "Camarero.findByApellido2", query = "SELECT c FROM Camarero c WHERE c.apellido2 = :apellido2")})
public class Camarero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdCamarero")
    private Long idCamarero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Apellido1")
    private String apellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Apellido2")
    private String apellido2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCamarero")
    private List<Factura> facturaList;

    public Camarero() {
    }

    public Camarero(Long idCamarero) {
        this.idCamarero = idCamarero;
    }

    public Camarero(Long idCamarero, String nombre, String apellido1, String apellido2) {
        this.idCamarero = idCamarero;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public Long getIdCamarero() {
        return idCamarero;
    }

    public void setIdCamarero(Long idCamarero) {
        this.idCamarero = idCamarero;
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
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCamarero != null ? idCamarero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camarero)) {
            return false;
        }
        Camarero other = (Camarero) object;
        if ((this.idCamarero == null && other.idCamarero != null) || (this.idCamarero != null && !this.idCamarero.equals(other.idCamarero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lamejorcocina.entidades.Camarero[ idCamarero=" + idCamarero + " ]";
    }
    
}
