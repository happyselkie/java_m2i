package org.example.ex05.model.repository;

import org.example.ex05.model.entity.Dog;
import org.example.ex05.util.SessionFactorySingleton;

import java.util.ArrayList;
import java.util.List;

public class DogRepository extends Repository<Dog>{ 

    public DogRepository() {
        super(SessionFactorySingleton.getSessionFactory(), Dog.class);
    }

    @Override
    public List<Dog> get() {
        try{
            session = sessionFactory.openSession();
           List<Dog> dogs = session.createQuery("select d from Dog d", Dog.class).getResultList();
            return dogs;
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }



}
