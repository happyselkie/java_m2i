package org.example.exercices_pattern.pere_noel.observers;

import org.example.exercices_pattern.pere_noel.decorators.GiftRibbon;
import org.example.exercices_pattern.pere_noel.factories.Toy;

public class GiftObserver implements Observer{

    private String name;

    public GiftObserver(String name) {
        this.name = name;
    }

    @Override
    public void notify(Toy toy) {
        if(toy instanceof GiftObserver || toy instanceof GiftRibbon) System.out.println("Cadeau à préparer :" + toy.getToy());
    }
}
