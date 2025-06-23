package org.example.structural.decorator;

// Un décorateur abstrait pour les pizza qui va nous permettre de créer des décorateurs concrets
public abstract class PizzaDecorator implements Pizza{

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}
