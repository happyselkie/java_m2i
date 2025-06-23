package org.example.demos.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionSingleton {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    private SessionSingleton() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static synchronized Session getSession(){
        if(sessionFactory == null){
            new SessionSingleton();
        }
        return sessionFactory.openSession();
    }

    public static void closeSession(){
        sessionFactory.close();
        registry.close();
    }

}
