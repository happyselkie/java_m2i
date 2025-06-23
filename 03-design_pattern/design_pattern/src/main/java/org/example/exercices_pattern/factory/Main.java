package org.example.exercices_pattern.factory;

public class Main {
    public static void main(String[] args) {
        /*AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.makeSound();

        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.makeSound();*/

        BigFactory bigFactory = new BigFactory();
        bigFactory.saveFactory("chien", new DogFactory());
        bigFactory.saveFactory("chat", new CatFactory());

        Animal cat = bigFactory.buildAnimal("chat");
        cat.makeSound();

        Animal dog = bigFactory.buildAnimal("chien");
        dog.makeSound();



    }
}
