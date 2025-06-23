package org.example.exercices_pattern.pere_noel.decorators;

import org.example.exercices_pattern.pere_noel.factories.Toy;
import org.example.exercices_pattern.pere_noel.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class GiftDecorator implements Toy {
    protected Toy toy;
    protected List<Observer> elfs = new ArrayList<>();

    public GiftDecorator(Toy toy) {
        this.toy = toy;
        this.notifyObservers(toy);
    }

    @Override
    public String getToy() {
        return toy.getToy();
    }

    public void addObserver(Observer observer){
        elfs.add(observer);
    }

    public void notifyObservers(Toy toy){
        for (Observer observer : elfs){
            observer.notify(toy);
        }
    }


}
