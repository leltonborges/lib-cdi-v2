package br.com.cdi.api.lib.jsf.annotation;

import javax.faces.event.PhaseId;
import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Qualifier
public @interface Phase {
    Phases value();

    enum Phases {
        RESTORE_VIEW(PhaseId.RESTORE_VIEW),
        APPLY_REQUEST_VALUES(PhaseId.APPLY_REQUEST_VALUES),
        PROCESS_VALIDATIONS(PhaseId.PROCESS_VALIDATIONS),
        UPDATE_MODEL_VALUES(PhaseId.UPDATE_MODEL_VALUES),
        INVOKE_APPLICATION(PhaseId.INVOKE_APPLICATION),
        RENDER_RESPONSE(PhaseId.RENDER_RESPONSE);

        PhaseId phaseId;

        Phases(PhaseId phaseId) {
            this.phaseId = phaseId;
        }

        public PhaseId getPhaseId() {
            return phaseId;
        }
    }

}
