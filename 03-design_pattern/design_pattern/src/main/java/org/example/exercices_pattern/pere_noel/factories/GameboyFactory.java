package org.example.exercices_pattern.pere_noel.factories;

public class GameboyFactory extends ToyFactory{

    @Override
    public Gameboy createToy(String kid) {
        return new Gameboy(kid);
    }
}
