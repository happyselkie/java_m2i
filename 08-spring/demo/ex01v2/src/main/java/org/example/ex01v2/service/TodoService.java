package org.example.ex01v2.service;


import lombok.Getter;
import lombok.Setter;
import org.example.ex01v2.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Getter
@Setter
@Service
public class TodoService {

    private ArrayList<Todo> todos = new ArrayList<>();

    public TodoService(){
        this.todos.add(new Todo("todo1","description 1",true));
        this.todos.add(new Todo("todo2","description 2",false));
        this.todos.add(new Todo("todo3","description 3",true));
        this.todos.add(new Todo("todo3","description 3",true));
        this.todos.add(new Todo("todo3","description 3",true));
        this.todos.add(new Todo("todo3","description 3",true));
        this.todos.add(new Todo("todo3","description 3",true));
        this.todos.add(new Todo("todo3","description 3",true));
    }
}
