package org.example.ex05.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ex05.model.entity.Dog;
import org.example.ex05.model.service.DogService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "DogServlet", value = {"/dogs", "/dogs/*"})
public class DogServlet extends HttpServlet {

    private List<Dog> dogs;
    private DogService dogService;

    @Override
    public void init() throws ServletException {
        dogService = new DogService();
        dogs = dogService.getAll();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        System.out.println(pathInfo);
        String error = "";

        switch (pathInfo) {
            case "/list":
                dogList(req, resp, dogs, error);
                break;
            case "/add":
                Dog newDog = new Dog();
                dogDetail(req, resp, newDog, false);
                break;
            case "/delete":
                dogDelete(req, resp);
                break;
            case "/edit":
                int id = Integer.parseInt(req.getParameter("id"));
                if (id > 0) {
                    dogDetail(req, resp, dogService.getById(id), true);
                } else {
                    req.setAttribute("error", "L'identifiant n'existe pas");
                    resp.sendRedirect("add");
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        LocalDate dob = LocalDate.parse(req.getParameter("birthday"));

        int edit = Integer.parseInt(req.getParameter("edit"));

        Dog dog;

        if(edit > 0){
            dog = dogService.getById(edit);
            dog.setName(name);
            dog.setBreed(breed);
            dog.setBirthday(dob);
            dogService.update(dog);
        } else {
            dog = dogService.save(name, breed, dob);
            dogs.add(dog);
        }
        dogs = dogService.getAll();

        resp.sendRedirect("edit?id=" + dog.getId());
    }


    protected void dogList(HttpServletRequest req, HttpServletResponse resp, List<Dog> dogs, String error) throws ServletException, IOException {
        req.setAttribute("dogs", dogs);
        req.setAttribute("error", error);
        req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
    }


    protected void dogDetail(HttpServletRequest req, HttpServletResponse resp, Dog dog, boolean edit) throws ServletException, IOException {
        req.setAttribute("edit", edit);
        req.setAttribute("dog", dog);
        req.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(req, resp);
    }

    protected void dogDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if (id > 0) {
            dogService.delete(id);
            dogs = dogService.getAll();
            req.setAttribute("dogs", dogs);
            req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
        } else {
            String error = "No dog selected";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
        }
    }

}
