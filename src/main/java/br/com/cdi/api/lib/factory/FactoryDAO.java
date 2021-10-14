package br.com.cdi.api.lib.factory;

import br.com.cdi.api.lib.DAO.DAO;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class FactoryDAO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    @Produces
    public <T,I> DAO<T,I> createDAO(@NotNull InjectionPoint point){
        ParameterizedType parameterizedType = (ParameterizedType) point.getType();
        Class<T> tClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        return  new DAO<T,I>(tClass, manager);
    }
}
