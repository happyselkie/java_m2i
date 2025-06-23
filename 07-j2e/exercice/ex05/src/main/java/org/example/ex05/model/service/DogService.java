package org.example.ex05.model.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.ex05.model.entity.Dog;
import org.example.ex05.model.repository.DogRepository;

import java.time.LocalDate;
import java.util.List;

public class DogService {

    private static DogRepository dogRepository;

    public DogService() {
        dogRepository = new DogRepository();
    }

    public Dog getById(int id) throws EntityNotFoundException { return dogRepository.get(id); }

    public List<Dog> getAll() {return dogRepository.get();}

    public Dog save(String name, String breed, LocalDate birthday) {
        Dog dog =  new Dog(name, breed, birthday);
        dogRepository.save(dog);
        return dog;
    }

    public Dog update(Dog dog) {
        try{
            dogRepository.get(dog.getId());
            return dogRepository.update(dog);
        } catch (EntityNotFoundException e){
            System.out.println("Ce chien n'existe pas");
            return null;
        }
    }

    public void delete(int id) { dogRepository.delete(id); }

}
