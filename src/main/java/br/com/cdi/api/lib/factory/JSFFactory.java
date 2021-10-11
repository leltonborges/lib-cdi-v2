package br.com.cdi.api.lib.factory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import java.io.Serializable;

public class JSFFactory implements Serializable {
    private static final long serialVersionUID = 1l;

    @Produces
    @RequestScoped
    public FacesContext geFacesContext(){
        return FacesContext.getCurrentInstance();
    }
}
