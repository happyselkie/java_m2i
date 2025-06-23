package org.example.tp_parc.dao;

import org.example.tp_parc.utils.DatabaseManager;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class BaseDAO<T> {

    protected EntityManager em;

    public BaseDAO() {
        em = DatabaseManager.getEntityManager();
    }

    public T save (T element){
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
        return element;
    }

    public T getById (int id,Class<T> tClass){
        return em.find(tClass,id);
    }

    public T update (T element){
        try{
            em.getTransaction().begin();
            em.merge(element);
            em.getTransaction().commit();
            return element;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean delete (int id,Class<T> tClass){
        T elementFound = getById(id,tClass);
        if(elementFound != null){
            em.getTransaction().begin();
            em.remove(elementFound);
            em.getTransaction().commit();
            return true;
            }
        return false;
    }


}
