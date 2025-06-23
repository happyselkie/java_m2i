package org.example.exercices_pattern.pere_noel.observers;

import org.example.exercices_pattern.pere_noel.factories.Toy;

public class PackageObserver implements Observer{

    private String name;

    public PackageObserver(String name) {
        this.name = name;
    }
    @Override
    public void notify(Toy toy) {
         System.out.println("Taille du colis :" + toy.getSize());
    }
}
