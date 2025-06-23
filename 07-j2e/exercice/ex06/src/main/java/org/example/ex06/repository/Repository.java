package org.example.ex06.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class Repository<T> {

    protected Session session;

    public Repository(Session session) {
        this.session = session;
    }

    public void create(T o){
        session.persist(o);
    }

    abstract T findById(int id);

    abstract List<T> findAll();

}
