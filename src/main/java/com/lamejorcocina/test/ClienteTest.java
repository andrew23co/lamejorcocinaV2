/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamejorcocina.test;

import com.lamejorcocina.entidades.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andres Gamba
 */
public class ClienteTest {

    private static EntityManager em;
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        
        emf =  Persistence.createEntityManagerFactory("lamejorcocina");
        em = emf.createEntityManager();        
        
        List<Cliente> cs = (List<Cliente>) em.createQuery("SELECT c FROM Cliente c").getResultList();
        
        for (Cliente c: cs){
            System.out.println("Nombre "+c.getNombre());
        }
    }
}
