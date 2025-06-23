package org.example.ex01.service;

import org.example.ex01.model.Todo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class TodoService implements ModelService<Todo> {

    private List<Todo> todos;

    public TodoService() {
        this.todos = new ArrayList<>();
    }

    @Override
    public List<Todo> findAll() {
        return todos;
    }

    @Override
    public Todo findById(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) return todo;
        }
        return null;
    }

    @Override
    public Todo find(Todo model) {
        for (Todo todo : todos) {
            if (model.equals(todo)) return todo;
        }
        return null;
    }

    @Override
    public Todo save(Todo model) {
        todos.add(model);
        return model;
    }

    @Override
    public Todo delete(Todo model) {
        todos.remove(model);
        return model;
    }

}

