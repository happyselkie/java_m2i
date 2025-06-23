package org.example.model;

public class PriorityTodo extends Todo{

    private String priority;
    private boolean done = false;

    public PriorityTodo(int id, String name, String description, String priority) {
        super(id, name, description);
        this.priority = priority;
    }

    @Override
    public String toString() {
        String checkbox;
        if(done == false) checkbox = "[ ]";
        else checkbox = "[X]";

        return checkbox + " (id:"+super.getId()+") [Prioritaire - "+priority.toUpperCase()+"] " + super.getName() + " : " + super.getDescription();
    }
}
