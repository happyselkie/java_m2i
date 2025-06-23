package org.example.base.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TextServlet", value = "/text-servlet")
public class TextServlet extends HttpServlet {

    private String texte;

    public void init() {
        texte = "Never gonna give you up";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
        out.println(texte);
    }

    public void destroy() {
    }

}
