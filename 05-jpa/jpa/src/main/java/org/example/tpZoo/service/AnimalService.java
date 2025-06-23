package org.example.tpZoo.service;

import org.example.tpZoo.entity.Animal;
import org.example.tpZoo.entity.AnimalDAO;
import org.example.tpZoo.utils.Diet;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

public class AnimalService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
    private EntityManager em = emf.createEntityManager();

    AnimalDAO animalDAO = new AnimalDAO(em);

    public Animal createAnimal(String name, int age, String diet, Date date){

        Animal animal = Animal.builder().name(name).age(age).diet(Diet.valueOf(diet.toUpperCase())).arrivalDate(date).build();

        animalDAO.save(animal);

        return animal;
    }

    public Animal findById(int id){
        return animalDAO.findById(id);
    }

    public List<Animal> findByDiet(Diet diet){
       return animalDAO.findByDiet(diet);
    }

    public List<Animal> findByName(String name){
        return animalDAO.findByName(name);
    }

    public void editAnimal(Animal animal, String name, int age, String diet, Date date){
        try{
           animalDAO.update(animal, name, age, Diet.valueOf(diet.toUpperCase()), date);

        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    public void delete(Animal animal){
       animalDAO.delete(animal);
    }
}
