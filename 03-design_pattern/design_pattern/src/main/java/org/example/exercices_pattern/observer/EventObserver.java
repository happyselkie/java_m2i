package org.example.exercices_pattern.observer;

public class EventObserver implements Observer {

    private String name;

    public EventObserver(String name) {
        this.name = name;
    }

    @Override
    public void notify(Event event) {
        System.out.println(name + ", un évènement a été créé: " + event);
    }
}
