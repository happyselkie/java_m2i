package org.example.jstl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TestServlet", value = "/test")
public class TestServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> prenoms = new ArrayList<String>();
        prenoms.add("John");
        prenoms.add("Jane");
        prenoms.add("Jack");
        prenoms.add("Bob");
        prenoms.add("Mary");
        prenoms.add("Tom");
        req.setAttribute("prenoms", prenoms);
        req.setAttribute("isTrue", true);
        req.setAttribute("isFalse", false);
        req.setAttribute("nameDemo", "super demo !");
        req.getRequestDispatcher("/WEB-INF/test.jsp").forward(req, resp);
    }
}
