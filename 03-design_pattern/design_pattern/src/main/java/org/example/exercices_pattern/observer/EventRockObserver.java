package org.example.exercices_pattern.observer;

public class EventRockObserver implements Observer{

    private String name;

    public EventRockObserver(String name) {
        this.name = name;
    }

    @Override
    public void notify(Event event) {
        if(event.getType() == "rock") System.out.println("Nouveau concert de rock ! : "+event);
    }
}
