package org.example.ex01.controller;

import org.example.ex01.model.Todo;
import org.example.ex01.service.ModelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

@Controller
public class TodoController {

    private ModelService modelService;

    public TodoController(ModelService modelService) {
        this.modelService = modelService;
    }

    @RequestMapping("/todos")
    public String todoList(Model model) {
        Todo todo = new Todo(1, "todo1", "todododo", true);
        modelService.save(todo);
        List<Todo> todos = modelService.findAll();
        model.addAttribute("todos", todos);
        return "todos";
    }

    /*@GetMapping("/todo/{id}")
    public String todoInfos(@PathVariable int id, Model model) {
        Todo todo =  todoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo/details";
    }*/

    @RequestMapping("/todo")
    public String todoInfos(Model model) {
        Random rand = new Random();
        List<Todo> todos = modelService.findAll();
        Todo todo = todos.get(rand.nextInt(todos.size()));

        model.addAttribute("todo", todo);
        return "todo/details";
    }


    /*@PostMapping("/todos")
    public String todoSubmit(@ModelAttribute Todo todo, Model model) {
        modelService.save(todo);
        model.addAttribute("todo", todo);
        return "result";
    }*/

}
