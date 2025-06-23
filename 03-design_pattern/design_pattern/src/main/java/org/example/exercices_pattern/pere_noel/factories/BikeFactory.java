package org.example.exercices_pattern.pere_noel.factories;

public class BikeFactory extends ToyFactory{
    @Override
    public Bike createToy(String kid) {
        return new Bike(kid);
    }
}
