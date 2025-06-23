package org.example.structural.decorator;

// Décorateur pour mes pizzas. Celui-ci ajoute des olives et doit être basé sur le décorateur Pizza abstrait.
public class OliveDecorator extends PizzaDecorator{

    public OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ " avec olives";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.75;
    }
}
