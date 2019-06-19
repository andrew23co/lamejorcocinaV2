/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamejorcocina.dao;

import com.lamejorcocina.entidades.Detallefactura;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andres Gamba
 */
@Stateless
public class DetallefacturaFacade extends AbstractFacade<Detallefactura> {

    @PersistenceContext(unitName = "lamejorcocina")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallefacturaFacade() {
        super(Detallefactura.class);
    }
    
}
