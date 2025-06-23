package org.example.tpZoo.entity;

import org.example.tpZoo.utils.Diet;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

public class AnimalDAO {
    private EntityManager em;

    public AnimalDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Animal animal) {
        em.getTransaction().begin();
        em.persist(animal);
        em.getTransaction().commit();
    }

    public Animal findById(int id){
        try {
            Animal animal = em.getReference(Animal.class, id);
            return animal;
        } catch (EntityNotFoundException e){
            System.out.printf(e.getMessage());
        }
        return null;
    }

    public List<Animal> findByDiet(Diet diet){
        TypedQuery<Animal> query = em.createQuery("Select a from Animal a where a.diet =  :diet", Animal.class);
        query.setParameter("diet", diet);
        return query.getResultList();
    }

    public List<Animal> findByName(String name){
        TypedQuery<Animal> query = em.createQuery("Select a from Animal a where a.name =  :name", Animal.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public void update(Animal animal, String name, int age, Diet diet, Date date){
        try{
            em.getTransaction().begin();
            animal.setName(name);
            animal.setAge(age);
            animal.setDiet(diet);
            animal.setArrivalDate(date);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(Animal animal){
        em.getTransaction().begin();
        em.remove(animal);
        em.getTransaction().commit();
    }
}
