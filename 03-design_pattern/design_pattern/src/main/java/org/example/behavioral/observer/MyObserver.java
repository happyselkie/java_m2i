package org.example.behavioral.observer;

public class MyObserver implements Observer{

    private String name;

    public MyObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " a reçu un message " + message);
    }

}
