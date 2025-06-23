package org.example.exercices_pattern.factory;

public class CatFactory extends AnimalFactory{

    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
