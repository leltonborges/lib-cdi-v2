package br.com.cdi.api.lib.transaction;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

//@Priority(Interceptor.Priority.APPLICATION) //outra forma de add interceptor
@Interceptor
@TransactionCDI
public class ManagerTransaction implements Serializable {
    private static final long serialVersionUID = 1l;

    private Transacionado transacionado;

    @Inject
    public ManagerTransaction(Transacionado transacionado) {
        this.transacionado = transacionado;
    }

    @AroundInvoke
    public Object interceptor(InvocationContext context) {
        return transacionado.executeTransacao(context);
    }
}



