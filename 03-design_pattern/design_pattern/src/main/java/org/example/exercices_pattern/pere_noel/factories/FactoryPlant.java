package org.example.exercices_pattern.pere_noel.factories;

import org.example.exercices_pattern.pere_noel.observers.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactoryPlant {
    private Map<String, ToyFactory> factoryMap = new HashMap<>();
    private List<Observer> elfs = new ArrayList<>();

    public void saveFactory(String typeFactory,ToyFactory factory){
        factoryMap.put(typeFactory, factory);
    };

    public Toy buildToy(String toyType, String kid){
        Toy newtoy = factoryMap.get(toyType).createToy(kid);
        this.notifyObservers(newtoy);
        return newtoy;
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
