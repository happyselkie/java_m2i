package org.example.structural;

import org.example.structural.decorator.CheeseDecorator;
import org.example.structural.decorator.OliveDecorator;
import org.example.structural.decorator.Pizza;
import org.example.structural.decorator.PlainPizza;

public class Main {
    public static void main(String[] args) {

        // Création d'une pizza basique
        Pizza basePizza = new PlainPizza();
        System.out.println(basePizza.getDescription() + ": " + basePizza.getCost()+"€");

        // Ajout de fromage pour créer une nouvelle pizza au fromage
        Pizza cheesePizza = new CheeseDecorator(basePizza);
        System.out.println(cheesePizza.getDescription() + ": " +cheesePizza.getCost()+"€");

        // Ajout d'olives sur la pizza au fromage
        Pizza olivePizza = new OliveDecorator(cheesePizza);
        System.out.println(olivePizza.getDescription() + ": " + olivePizza.getCost()+"€");

    }
}
