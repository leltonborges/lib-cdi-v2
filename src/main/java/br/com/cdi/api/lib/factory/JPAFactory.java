package br.com.cdi.api.lib.factory;

import br.com.cdi.api.lib.config.ConfigurationQualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.constraints.NotNull;
import java.util.Properties;

@ApplicationScoped
public class JPAFactory {
    private EntityManagerFactory factory;

    @Inject
    @ConfigurationQualifier
    @ApplicationScoped
    private Properties properties;

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

    @PostConstruct
    public void loadEMF() {
        factory = Persistence.createEntityManagerFactory(properties.getProperty("jpa.persistence.unit"));
    }

}
