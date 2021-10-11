package br.com.cdi.api.lib.factory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.constraints.NotNull;

public class JPAFactory {
    private static final String PERSISTENCE = "livraria";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE);

    @Produces
    @RequestScoped
    public EntityManager getManager() {
        return factory.createEntityManager();
    }

    public void closeManager(@Disposes @NotNull EntityManager manager){
        manager.close();
    }

}