/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamejorcocina.controller;

import com.lamejorcocina.controller.util.JsfUtil;
import com.lamejorcocina.controller.util.PaginationHelper;
import com.lamejorcocina.dao.CamareroFacade;
import com.lamejorcocina.dao.CamareroFacturacionMesFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author Gamba
 */
@Named("CamareroFacturacionMesController")
@SessionScoped
public class CamareroFacturacionMesController implements Serializable {

    private DataModel items = null;
    @EJB
    private com.lamejorcocina.dao.CamareroFacturacionMesFacade camFcd;
    private PaginationHelper pagination;

    public CamareroFacturacionMesController() {
    }

    private CamareroFacturacionMesFacade getFacade() {
        return camFcd;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        System.out.println("Registro 1");
        Logger.getLogger(CamareroFacturacionMesController.class.getName()).log(Level.SEVERE, "Registro 2");
        return JsfUtil.getSelectItems(camFcd.camareroFacturacionMes(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        System.out.println("Registro 1");
        Logger.getLogger(CamareroFacturacionMesController.class.getName()).log(Level.SEVERE, "Registro 2");
        return JsfUtil.getSelectItems(camFcd.camareroFacturacionMes(), true);
    }

}
