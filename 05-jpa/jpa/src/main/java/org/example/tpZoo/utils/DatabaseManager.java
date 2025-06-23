package org.example.tpZoo.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseManager {

    private static EntityManager instance;

    private DatabaseManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
        instance = emf.createEntityManager();
    }

    /*public static synchronized DatabaseManager getInstance() { // synchronized : proteger en cas de multi-threading, qu'une seule instance
        if(instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }*/

}
