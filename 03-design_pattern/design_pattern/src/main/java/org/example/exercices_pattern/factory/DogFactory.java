package org.example.exercices_pattern.factory;

public class DogFactory extends AnimalFactory{

    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
