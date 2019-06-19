/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamejorcocina.test;

import com.lamejorcocina.dao.ClienteFacade;
import com.lamejorcocina.entidades.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Andres Gamba
 */
@Named("clienteTest")
@SessionScoped
public class ClienteTest implements Serializable {

    @EJB
    private com.lamejorcocina.dao.ClienteFacade ejbFacade;
    
    public List<Cliente> lista() {
        return ejbFacade.findAll();
    }

}
