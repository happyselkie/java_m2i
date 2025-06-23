package org.example.exercices_pattern.builder.classes;

public class House {

    private int floors;
    private boolean piscine;
    private String roofing;
    private String color;

    public House(HouseBuilder builder) {
        floors = builder.getFloors();
        piscine = builder.isPiscine();
        roofing = builder.getRoofing();
        color = builder.getColor();
    }

    @Override
    public String toString() {
        return "House{" +
                "floors=" + floors +
                ", piscine=" + piscine +
                ", roofing='" + roofing + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
