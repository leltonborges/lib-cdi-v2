package br.com.cdi.api.lib.jsf.phaselistener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import java.io.Serializable;

public class PhaselistenerGeneric implements PhaseListener, Serializable {
    private static final long serialVersionUID = -2730244703677320677L;


    private PhaseListenerObserver observer = new PhaseListenerObserver();

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        observer.after()
                .fire(phaseEvent);
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        observer.before()
                .fire(phaseEvent);
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
