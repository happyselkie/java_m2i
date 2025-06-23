package org.example.exercices_pattern.pere_noel.factories;

public class Furby implements Toy{

    private String kid;
    private String size = "moyen";

    public Furby(String kid) {
        this.kid = kid;
    }

    public String getKid() {
        return kid;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String getToy() {
        return "Un furby pour "+kid;
    }

    @Override
    public String toString() {
        return this.getToy();
    }
}
