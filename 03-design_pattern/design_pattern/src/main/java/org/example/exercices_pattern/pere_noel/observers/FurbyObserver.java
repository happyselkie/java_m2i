package org.example.exercices_pattern.pere_noel.observers;

import org.example.exercices_pattern.pere_noel.factories.Furby;
import org.example.exercices_pattern.pere_noel.factories.Toy;

public class FurbyObserver implements Observer{
    private String name;

    public FurbyObserver(String name) {
        this.name = name;
    }

    @Override
    public void notify(Toy toy) {
        if(toy instanceof Furby) System.out.println(">> Pour " + name + ": " + toy.getToy());
    }

}
