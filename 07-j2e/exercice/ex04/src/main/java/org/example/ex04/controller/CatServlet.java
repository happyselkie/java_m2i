package org.example.ex04.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ex04.model.entity.Cat;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CatServlet", value = "/cats")
public class CatServlet  extends HttpServlet {

    private List<Cat> cats;

    @Override
    public void init() throws ServletException {
        cats = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cats", cats);
        getServletContext().getRequestDispatcher("/WEB-INF/catPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String race = req.getParameter("race");
        String favoriteMeal = req.getParameter("favMeal");
        LocalDate dob = LocalDate.parse(req.getParameter("DateOfBirth"));

        Cat cat = new Cat(name, race, favoriteMeal, dob);

        cats.add(cat);

        doGet(req, resp);
    }
}
