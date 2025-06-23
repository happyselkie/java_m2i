package org.example.exercice_tp;

public class Ramette extends ProductItem {

    double gram;

    public Ramette(String ref, String name, double prix, double gram) {
        super(ref, name, prix);
        this.gram = gram;
    }

    public double getGram() {
        return gram;
    }
}
