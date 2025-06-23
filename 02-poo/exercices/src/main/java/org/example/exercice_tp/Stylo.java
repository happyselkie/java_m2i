package org.example.exercice_tp;

public class Stylo extends ProductItem {

    private String color;

    public Stylo(String ref, String name, double prix, String color) {
        super(ref, name, prix);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

