/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamejorcocina.dao;

import com.lamejorcocina.entidades.CamareroFacturacionMes;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Gamba
 */
@Stateless
public class CamareroFacturacionMesFacade {

    @PersistenceContext(unitName = "lamejorcocina")
    private EntityManager em;

    private List<CamareroFacturacionMes> lista = null;

    private Class<CamareroFacturacionMes> entityClass;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CamareroFacturacionMesFacade() {

    }

    public List<CamareroFacturacionMes> findRange(int[] range) {
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
        javax.persistence.Query q = consultaReporte();//getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return this.lista.size();
    }

    public List<CamareroFacturacionMes> camareroFacturacionMes() {
        this.lista = new ArrayList<CamareroFacturacionMes>();
        this.lista = consultaReporte().getResultList();
        System.out.println("Registro 1");
        Logger.getLogger(CamareroFacade.class.getName()).log(Level.SEVERE, "Registro 2");
        for (CamareroFacturacionMes cf : lista) {
            System.out.println("Nombre: " + cf.getNombreCam());
        }
        return this.lista;
    }

    private Query consultaReporte() {
        String query = "SELECT "
                + "C.NOMBRE AS nombreCam, "
                + "C.APELLIDO1 AS apellidoCam, "
                + "MONTH(F.FECHAFACTURA) AS mesRep, "
                + "YEAR(F.FECHAFACTURA) AS anno, "
                + "SUM(DF.IMPORTE) AS totalMes FROM "
                + "Camarero AS C , "
                + "Factura AS F, "
                + "DetalleFactura AS DF "
                + "WHERE C.IDCAMARERO = F.IDCAMARERO AND "
                + "F.IDFACTURA = DF.IDFACTURA "
                + "GROUP BY C.IDCAMARERO, C.NOMBRE, C.APELLIDO1, MONTH(F.FECHAFACTURA), YEAR(F.FECHAFACTURA) "
                + "ORDER BY 5,4 DESC";
        Query q = this.getEntityManager().createNativeQuery(query);
        return q;

    }
}
