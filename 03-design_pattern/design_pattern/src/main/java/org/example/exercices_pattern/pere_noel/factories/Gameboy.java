package org.example.exercices_pattern.pere_noel.factories;

public class Gameboy implements Toy{

    private String kid;
    private String size = "petit";

    public Gameboy(String kid) {
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
        return "Un gameboy pour "+kid;
    }

    @Override
    public String toString() {
        return this.getToy();
    }
}
