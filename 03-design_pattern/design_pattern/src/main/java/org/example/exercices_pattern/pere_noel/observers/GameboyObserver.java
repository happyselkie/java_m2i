package org.example.exercices_pattern.pere_noel.observers;

import org.example.exercices_pattern.pere_noel.factories.Gameboy;
import org.example.exercices_pattern.pere_noel.factories.Toy;

public class GameboyObserver implements Observer{

    private String name;

    public GameboyObserver(String name) {
        this.name = name;
    }

    @Override
    public void notify(Toy toy) {
        if(toy instanceof Gameboy) System.out.println(">> Pour " + name + ": " + toy.getToy());
    }
}