package br.com.cdi.api.lib.DAO;

import br.com.cdi.api.lib.transaction.TransactionCDI;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;
import java.util.List;

public class DAO<T>{
    protected EntityManager manager;
    private Class<T> tClass;

    public DAO(Class<T> tClass, EntityManager manager) {
        this.tClass = tClass;
        this.manager = manager;
    }

    public void save(T entity) {
        if(entity == null) return;
        this.manager.persist(entity);
    }

    public void saveAll(Collection<T> list) {
        for (T t : list) {
            save(t);
        }
    }

    public void remove(T entity) {
        if(entity == null) return;
        this.manager.remove(this.manager.merge(entity));
    }

    public void update(T entity) {
        if(entity == null) return;

        this.manager.merge(entity);
    }

    public T getById(Integer id) {
        T result = manager.find(tClass, id);
        return result;
    }

    public List<T> getAll() {
        List<T> list;
        CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(tClass);
        query.select(query.from(tClass));
        list = manager.createQuery(query).getResultList();
        return list;
    }
}
