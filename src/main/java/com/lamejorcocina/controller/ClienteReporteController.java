package com.lamejorcocina.controller;

import com.lamejorcocina.controller.util.JsfUtil;
import com.lamejorcocina.controller.util.PaginationHelper;
import com.lamejorcocina.dao.ClienteFacade;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("clienteReporteController")
@SessionScoped
public class ClienteReporteController implements Serializable {

   
    private DataModel items = null;
    @EJB
    private com.lamejorcocina.dao.ClienteFacade ejbFacade;
    private PaginationHelper pagination;
  

    public ClienteReporteController() {
    }

      private ClienteFacade getFacade() {
        return ejbFacade;
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
        return JsfUtil.getSelectItems(ejbFacade.findAllClientesXMonto(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAllClientesXMonto(), true);
    }
}



