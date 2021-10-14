package br.com.cdi.api.lib.jsf.annotation;

import javax.enterprise.inject.Stereotype;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Stereotype
@Named
@ViewScoped
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewModel {
}
