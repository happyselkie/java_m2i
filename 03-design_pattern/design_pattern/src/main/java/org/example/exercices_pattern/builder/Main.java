package org.example.exercices_pattern.builder;


import org.example.exercices_pattern.builder.classes.House;
import org.example.exercices_pattern.builder.classes.HouseBuilder;

public class Main {
    public static void main(String[] args) {

        House house = new HouseBuilder().roofing("Tuiles en céramiques").floors(2).piscine(false).color("pink").build();

        System.out.println(house);
    }
}
