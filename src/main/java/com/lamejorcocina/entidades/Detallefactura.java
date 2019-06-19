/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamejorcocina.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres Gamba
 */
@Entity
@Table(name = "detallefactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallefactura.findAll", query = "SELECT d FROM Detallefactura d"),
    @NamedQuery(name = "Detallefactura.findByIdDetalleFactura", query = "SELECT d FROM Detallefactura d WHERE d.idDetalleFactura = :idDetalleFactura"),
    @NamedQuery(name = "Detallefactura.findByPlato", query = "SELECT d FROM Detallefactura d WHERE d.plato = :plato"),
    @NamedQuery(name = "Detallefactura.findByImporte", query = "SELECT d FROM Detallefactura d WHERE d.importe = :importe")})
public class Detallefactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdDetalleFactura")
    private Long idDetalleFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Plato")
    private String plato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Importe")
    private long importe;
    @JoinColumn(name = "IdFactura", referencedColumnName = "IdFactura")
    @ManyToOne(optional = false)
    private Factura idFactura;
    @JoinColumn(name = "IdCocinero", referencedColumnName = "IdCocinero")
    @ManyToOne(optional = false)
    private Cocinero idCocinero;

    public Detallefactura() {
    }

    public Detallefactura(Long idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public Detallefactura(Long idDetalleFactura, String plato, long importe) {
        this.idDetalleFactura = idDetalleFactura;
        this.plato = plato;
        this.importe = importe;
    }

    public Long getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(Long idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public long getImporte() {
        return importe;
    }

    public void setImporte(long importe) {
        this.importe = importe;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public Cocinero getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(Cocinero idCocinero) {
        this.idCocinero = idCocinero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleFactura != null ? idDetalleFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallefactura)) {
            return false;
        }
        Detallefactura other = (Detallefactura) object;
        if ((this.idDetalleFactura == null && other.idDetalleFactura != null) || (this.idDetalleFactura != null && !this.idDetalleFactura.equals(other.idDetalleFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lamejorcocina.entidades.Detallefactura[ idDetalleFactura=" + idDetalleFactura + " ]";
    }
    
}
