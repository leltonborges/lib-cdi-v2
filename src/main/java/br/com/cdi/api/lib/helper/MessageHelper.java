package br.com.cdi.api.lib.helper;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

public class MessageHelper implements Serializable {
    private static final long serialVersionUID = 1l;

    @Inject
    private FacesContext context;

    public void  addMessage(FacesMessage message){
        addMessage(null, message);
    }

    public void addMessage(String clientID, FacesMessage message){
        context.addMessage(clientID, message);
    }

    public MessageHelper onFlash(){
        context.getExternalContext().getFlash().setKeepMessages(true);
        return  this;
    }
}
