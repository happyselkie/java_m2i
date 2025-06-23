package org.example.structural.decorator;

// Décorateur pour mes pizzas. Celui-ci ajoute du fromage et doit être basé sur le décorateur Pizza abstrait.
public class CheeseDecorator extends PizzaDecorator{

    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " au Fromage";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.50;
    }
}
