package org.example.ex03.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.ex03.model.entity.Person;

@WebServlet(name = "HelloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {

    private List<Person> persons = new ArrayList<>();

    public void init() {
        Person person1 = new Person("Toto", "Tata", 42);
        persons.add(person1);
        Person person2 = new Person("Titi", "Tutu", 24);
        persons.add(person2);
        Person person3 = new Person("Rick", "Astley", 24);
        persons.add(person3);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("personnes", persons);

        getServletContext().getRequestDispatcher("/hello.jsp").forward(request, response);
    }
}