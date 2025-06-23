package org.example.exercices_pattern.observer;

public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();

        Observer eventObserver = new EventObserver("eventObserver");
        Observer mailObserver = new MailObserver("mailObserver");
        Observer rockObserver = new EventRockObserver("rockObserver");

        eventManager.addObserver(eventObserver);
        eventManager.addObserver(mailObserver);
        eventManager.addObserver(rockObserver);


        eventManager.newEvent("Concert Hans Zimmer", "bo");
        eventManager.newEvent("Concert Led Zepplin", "rock");
    }
}
