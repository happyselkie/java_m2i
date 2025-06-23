package org.example.exercices_pattern.pere_noel.factories;

public class Bike implements Toy{

    private String kid;
    private String size = "grand";

    public Bike(String kid) {
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
        return "Un vélo pour "+kid;
    }

    @Override
    public String toString() {
        return this.getToy();
    }
}
