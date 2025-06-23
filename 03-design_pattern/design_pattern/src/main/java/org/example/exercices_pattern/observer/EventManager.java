package org.example.exercices_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private List<Observer> observers = new ArrayList<>();


    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyObservers(Event event){
        for (Observer observer : observers){
            observer.notify(event);
        }
    }

    public Event newEvent(String name, String type){
        Event newEvent = new Event(name, type);
        this.notifyObservers(newEvent);
        return newEvent;
    }
}
