package br.com.cdi.api.lib.helper;

import br.com.cdi.api.lib.jsf.annotation.ScopeMap;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import java.io.Serializable;

public class MessageHelper implements Serializable {
    private static final long serialVersionUID = 1l;

    @Inject
    private FacesContext context;

    @Inject
    private Flash flash;

    public void  addMessage(FacesMessage message){
        addMessage(null, message);
    }

    public void addMessage(String clientID, FacesMessage message){
        context.addMessage(clientID, message);
    }

    public MessageHelper onFlash(){
        flash.setKeepMessages(true);
        return this;
    }
}
