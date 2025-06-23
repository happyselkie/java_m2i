package org.example.exercices_pattern.builder.classes;

public class HouseBuilder {

    private int floors;
    private boolean piscine;
    private String roofing;
    private String color;


    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public boolean isPiscine() {
        return piscine;
    }

    public void setPiscine(boolean piscine) {
        this.piscine = piscine;
    }

    public String getRoofing() {
        return roofing;
    }

    public void setRoofing(String roofing) {
        this.roofing = roofing;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public HouseBuilder floors(int floors){
        this.floors = floors;
        return this;
    }

    public HouseBuilder piscine(boolean piscine){
        this.piscine = piscine;
        return this;
    }

    public HouseBuilder roofing(String roofing){
        this.roofing = roofing;
        return this;
    }
    public HouseBuilder color(String color){
        this.color = color;
        return this;
    }



    public House build(){
        return new House(this);
    }
}
