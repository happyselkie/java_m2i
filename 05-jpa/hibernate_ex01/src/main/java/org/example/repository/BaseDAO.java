package org.example.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.zip.CheckedOutputStream;

public abstract class BaseDAO<T> {
    protected SessionFactory sessionFactory;
    protected Class<T> type;
    protected Session session;

    public BaseDAO(SessionFactory sessionFactory,Class<T> type) {
        this.sessionFactory = sessionFactory;
        this.type = type;
    }

    public T save (T element){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(element);
            session.getTransaction().commit();
            return element;
        }catch (Exception ex){
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean delete (int id){
        T found = get(id);
        if(found !=null){
            try{
                session = sessionFactory.openSession();
                session.beginTransaction();
                session.delete(found);
                session.getTransaction().commit();
                return true;
            }catch (Exception ex){
                session.getTransaction().rollback();
                return false;
            }
            finally {
                session.close();
            }
        }else{
            System.out.println("Element at id : "+id+" not found");
            return false;
        }
    }

    public T get (int id){
        try{
            session = sessionFactory.openSession();
            return session.get(type,id);
        }catch (Exception ex){
            return null;
        }finally {
            session.close();
        }
    }

    public abstract List<T> get();

}
