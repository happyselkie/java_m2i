package org.example.service;

import org.example.model.PriorityTodo;
import org.example.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoServiceImpl implements TodoService{

    private static List<Todo> todoList = new ArrayList<>();
    private static int cpt = 1;

    @Override
    public List<Todo> getAll() {
        return todoList;
    }

    public List<Todo> getAllUndone() {
        List<Todo> todoUndone = new ArrayList<>();
        for(Todo todo : todoList){
            if(todo.isDone() == false) todoUndone.add(todo);
        }
        return todoUndone;
    }

    @Override
    public Todo getById(int id) {
        for(Todo todo : todoList){
            if(todo.getId() == id) return todo;
        }
        return null;
    }

    @Override
    public void add(String name, String description) {
        Todo newTodo = new Todo(cpt++, name, description);
        todoList.add(newTodo);
    }


    public void add(String name, String description, String priority) {
        Todo newTodo = new Todo(cpt++, name, description);
        if (priority != "") {
            newTodo = new PriorityTodo(cpt++, name, description, priority);
        }
        todoList.add(newTodo);
    }


    @Override
    public void update(int id, String name, String description, boolean done) {
        Todo todoToUpdate = this.getById(id);
        todoToUpdate.setName(name);
        todoToUpdate.setDescription(description);
        todoToUpdate.setDone(done);
    }

    @Override
    public void remove(int id) {
        Todo todoToRemove = this.getById(id);
        todoList.remove(todoToRemove);
        todoToRemove = null;
    }

    @Override
    public void toggleDone(int id) {
        Todo todoToToggle = this.getById(id);
        todoToToggle.setDone(!todoToToggle.isDone());
    }
}
