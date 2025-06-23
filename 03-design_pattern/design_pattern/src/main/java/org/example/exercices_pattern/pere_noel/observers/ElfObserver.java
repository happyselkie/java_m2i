package org.example.exercices_pattern.pere_noel.observers;

import org.example.exercices_pattern.pere_noel.factories.Toy;

public class ElfObserver implements Observer{
    private String name;

    public ElfObserver(String name) {
        this.name = name;
    }

    @Override
    public void notify(Toy toy) {
        System.out.println(name + ", un cadeau a été créé: " + toy);
    }
}
