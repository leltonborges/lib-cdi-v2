package br.com.cdi.api.lib.factory;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.constraints.NotNull;

@ApplicationScoped
public class JPAFactory {
    private final String PERSISTENCE = "livraria";
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE);

    @Produces
    @RequestScoped
    public EntityManager getManager() {
        return factory.createEntityManager();
    }

    public void closeManager(@Disposes @NotNull EntityManager manager){
        manager.close();
    }

    @PreDestroy
    public void preDestroyFactory(){
        if(factory.isOpen()){
            factory.close();
        }
    }

}
