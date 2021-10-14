package br.com.cdi.api.lib.jsf.phaselistener;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface After {
}
