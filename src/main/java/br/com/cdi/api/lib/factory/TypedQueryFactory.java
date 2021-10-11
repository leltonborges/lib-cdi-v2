package br.com.cdi.api.lib.factory;

import br.com.cdi.api.lib.jpa.annotation.Query;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;

public class TypedQueryFactory {

    @Inject
    private EntityManager manager;

    @Produces
    @Query("")
    public <T> TypedQuery<T> factoryQuery(InjectionPoint point){
        ParameterizedType parameterizedType =(ParameterizedType) point.getType();
        Class<T> xClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        String jpql = point.getAnnotated().getAnnotation(Query.class).value();
        return manager.createQuery(jpql, xClass);
    }
}
