package br.com.cdi.api.lib.transaction;

import javax.inject.Inject;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import java.io.Serializable;

public class TransactionDefault implements Serializable {
 

    @Inject
    private EntityManager manager;
    public Object executeTransaction(InvocationContext context){
        manager.getTransaction().begin();
        try {
            Object result = context.proceed();
            manager.getTransaction().commit();
            return result;
        }catch (Exception e){
            manager.getTransaction().rollback();
            throw new RuntimeException("Erro durante o prcesso getManagerTransaction\n"+ e);
        }
    }
}
