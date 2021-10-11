package br.com.cdi.api.lib.transaction;

import javax.inject.Inject;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import java.io.Serializable;

//@Interceptor
//@TransactionCDI
public class ManagerTransaction implements Serializable {
    private static final long serialVersionUID = 1l;

    @Inject
    private EntityManager manager;

//    @AroundInvoke
    public Object getManagerTransaction(InvocationContext context) throws Exception{
        manager.getTransaction().begin();
        Object result = context.proceed();
        manager.getTransaction().begin();
        return  result;
    }
}
