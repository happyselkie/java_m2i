package org.example.exercices_pattern.factory;

public class Cat implements Animal{

    @Override
    public void makeSound() {
        System.out.println("MIAOUW");
    }
}
