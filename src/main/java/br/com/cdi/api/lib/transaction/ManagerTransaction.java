package br.com.cdi.api.lib.transaction;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import java.io.Serializable;

@Interceptor
@TransactionCDI
public class ManagerTransaction implements Serializable {
    private static final long serialVersionUID = 1l;

    @Inject
    private EntityManager manager;

    @AroundInvoke
    public Object getManagerTransaction(InvocationContext context) {
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



