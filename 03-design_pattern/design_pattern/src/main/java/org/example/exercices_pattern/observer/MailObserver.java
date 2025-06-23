package org.example.exercices_pattern.observer;

public class MailObserver implements Observer{

    private String name;

    public MailObserver(String name) {
        this.name = name;
    }

    @Override
    public void notify(Event event) {
        System.out.println("Envoi de mail pour l'évent : " + event);
    }
}
