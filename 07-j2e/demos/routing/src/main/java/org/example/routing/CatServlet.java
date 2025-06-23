package org.example.routing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CatServlet", value = {"/cat/*"})
public class CatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        System.out.println(pathInfo);

        switch (pathInfo) {
            case "/list":
                req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
                break;
            case "/add":
                req.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(req, resp);
                break;
        }


    }

}
