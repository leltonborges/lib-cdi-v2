package br.com.cdi.api.lib.transaction;

import javax.enterprise.inject.Typed;
import javax.inject.Inject;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Typed(Transacionado.class)
public class TransactionDefault implements Transacionado {
    private static final long serialVersionUID = 1l;

    @Inject
    protected EntityManager manager;
    public Object executeTransacao(InvocationContext context){
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
