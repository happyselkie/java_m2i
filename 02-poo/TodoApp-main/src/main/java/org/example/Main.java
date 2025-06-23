package org.example;


import org.example.ihm.Ihm;
import org.example.service.TodoService;
import org.example.service.TodoServiceImpl;


public class Main {
    public static void main(String[] args) {
        TodoService service = new TodoServiceImpl();
        Ihm ihm = new Ihm(service);
        ihm.start();
    }
}