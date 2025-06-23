package org.example.exercices_pattern.factory;

public class Dog implements Animal{

    @Override
    public void makeSound() {
        System.out.println("WOOF");
    }
}
