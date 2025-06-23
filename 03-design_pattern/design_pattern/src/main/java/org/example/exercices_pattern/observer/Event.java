package org.example.exercices_pattern.observer;

public class Event {

    private String name;
    private String type;

    public Event(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Évenement " + name + ": "+type;
    }
}
