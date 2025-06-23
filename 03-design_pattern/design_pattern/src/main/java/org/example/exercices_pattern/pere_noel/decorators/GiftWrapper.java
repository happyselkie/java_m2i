package org.example.exercices_pattern.pere_noel.decorators;

import org.example.exercices_pattern.pere_noel.factories.Toy;

public class GiftWrapper extends GiftDecorator{

    private String wrapper;

    public GiftWrapper(Toy toy, String wrapper) {
        super(toy);
        this.wrapper = wrapper;
        super.notifyObservers(toy);
    }

    @Override
    public String getToy() {
        return super.getToy() + ", emballé dans un paquet "+wrapper + ". Taille du paquet : " + this.getSize();
    }

    @Override
    public String getSize() {
        return toy.getSize();
    }
}
