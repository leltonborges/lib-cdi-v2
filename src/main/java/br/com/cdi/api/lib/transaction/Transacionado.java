package br.com.cdi.api.lib.transaction;

import javax.interceptor.InvocationContext;
import java.io.Serializable;

public interface Transacionado extends Serializable {
    public Object executeTransacao(InvocationContext context);
}
