package org.example.ex01v2.controller;

import org.example.ex01v2.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }


    @GetMapping("/todo")
    public String getOneTodo(Model model){
        model.addAttribute("todo",todoService.getTodos().get(3));
        return "todo";
    }


    @GetMapping("/")
    public String getAllTodos(Model model){
        model.addAttribute("todos",todoService.getTodos());
        return "todos";
    }
}
