package org.example.base.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VariableServlet", value = "/variables")
public class VariableServlet extends HttpServlet {

    private String prenom;
    private String nom;
    private List<String> paroles;

    @Override
    public void init() throws ServletException {
        prenom = "Rick";
        nom = "Astley";
        paroles = new ArrayList<>();
        paroles.add("Never gonna give you up");
        paroles.add("Never gonna let you down");
        paroles.add("Never gonna run around and desert you");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("prenom", prenom);
        request.setAttribute("nom", nom);
        request.setAttribute("paroles", paroles);


        request.getRequestDispatcher("/pages/variables.jsp").forward(request, response);

    }

}
