package org.example.ex05.model.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class Repository<T> {
    protected SessionFactory sessionFactory;
    protected Class<T> type;
    protected Session session;

    public Repository(SessionFactory sessionFactory, Class<T> type) {
        this.sessionFactory = sessionFactory;
        this.type = type;
    }

    public T save (T element){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(element);
            session.getTransaction().commit();
            return element;
        }catch (Exception ex){
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public T update (T element){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.merge(element);
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
                session.remove(found);
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
