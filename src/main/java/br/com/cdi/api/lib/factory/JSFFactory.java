package br.com.cdi.api.lib.factory;

import br.com.cdi.api.lib.jsf.annotation.SessionMap;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import java.io.Serializable;
import java.util.Map;

public class JSFFactory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Produces
    @RequestScoped
    public FacesContext getFacesContext(){
        return FacesContext.getCurrentInstance();
    }

    @Produces
    @RequestScoped
    public Flash getFlash(){
        return  getExternalContext().getFlash();
    }


    //TODO não resolvido
//    @Produces
//    @SessionMap
//    public Map<String, Object> sessionMap(){
//        return getExternalContext().getSessionMap();
//    }

    @Produces
    public Map<String, Object> requestMap(){
        return  getExternalContext().getRequestMap();
    }

    @Produces
    public Map<String, Object> applicationMap(){
        return getExternalContext().getApplicationMap();
    }

    private ExternalContext getExternalContext() {
        return getFacesContext().getExternalContext();
    }
}
