/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamejorcocina.test;

import com.lamejorcocina.controller.ClienteController;
import com.lamejorcocina.entidades.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andres Gamba
 */
public class ClienteTest{
    
    private static ClienteController cc;

    public static void main(String[] args) {
        
               cc = new ClienteController();
        
        List<Cliente> cs = (List<Cliente>) cc.getItems();
        
        for (Cliente c: cs){
   
                   try {
                       Class.forName("asd");
                   } catch (ClassNotFoundException ex) {
                       Logger.getLogger(ClienteTest.class.getName()).log(Level.SEVERE, null, ex);
                   }
           
        }
    }
}
