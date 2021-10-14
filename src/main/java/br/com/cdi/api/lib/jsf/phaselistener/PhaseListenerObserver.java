package br.com.cdi.api.lib.jsf.phaselistener;

import br.com.cdi.api.lib.jsf.annotation.PhaseLiteral;

import javax.enterprise.event.Event;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;
import java.io.Serializable;
import java.lang.annotation.Annotation;

public class PhaseListenerObserver implements Serializable {
    private static final long serialVersionUID = -7378845517908106157L;

    private BeanManager observer = CDI.current().getBeanManager();

    Annotation moment;

    public PhaseListenerObserver after() {
        this.moment = new AnnotationLiteral<After>(){};
        return this;
    }

    public PhaseListenerObserver before() {
        this.moment = new AnnotationLiteral<Before>() {
        };
        return this;
    }

    public void fire(PhaseEvent event){
        observer.fireEvent(event, moment, new PhaseLiteral(event.getPhaseId()));
    }
}
