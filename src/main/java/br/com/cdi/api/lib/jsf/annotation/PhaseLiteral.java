package br.com.cdi.api.lib.jsf.annotation;

import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseId;
import java.io.Serializable;

public class PhaseLiteral extends AnnotationLiteral<Phase> implements Phase, Serializable {
    private static final long serialVersionUID = 4444843333881082619L;

    private Phases phases;

    public PhaseLiteral(PhaseId phaseId) {
        phases = Phases.valueOf(phaseId.getName());
    }

    @Override
    public Phases value() {
        return phases;
    }
}
