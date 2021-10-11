package br.com.cdi.api.lib.jsf.annotation;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ScopeMap {
    ScopeMap.Scope value();

    enum  Scope{
        REQUEST,SESSION,APPLICATION;
    }
}
