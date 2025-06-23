package org.example.exercices_pattern.pere_noel.decorators;

import org.example.exercices_pattern.pere_noel.factories.Toy;

public class GiftRibbon extends GiftDecorator{

    private String ribbon;

    public GiftRibbon(Toy toy, String ribbon) {
        super(toy);
        this.ribbon = ribbon;
        super.notifyObservers(toy);
    }

    @Override
    public String getToy() {
        return super.getToy() + ", avec du ruban "+ribbon+ ". Taille du paquet : " + this.getSize();
    }

    @Override
    public String getSize() {
        return toy.getSize();
    }
}
