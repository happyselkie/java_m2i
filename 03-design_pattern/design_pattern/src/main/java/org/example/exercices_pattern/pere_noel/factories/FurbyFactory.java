package org.example.exercices_pattern.pere_noel.factories;

public class FurbyFactory extends ToyFactory{

    @Override
    public Furby createToy(String kid) {
        return new Furby(kid);
    }

}
