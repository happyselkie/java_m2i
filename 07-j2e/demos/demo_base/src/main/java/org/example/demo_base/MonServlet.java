package org.example.demo_base;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MonServlet", value = "/mon-servlet")
public class MonServlet extends HttpServlet {

    private String prenom;

    public void init() throws ServletException {
        System.out.println("MonServlet init");
        prenom = "Toto";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Une requête Get a été envoye à /mon-servlet");

        //On envoit le type de réponse
        response.setContentType("text/html");

        //Première méthode pour renvoyer du contenu :
        /*PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1> Coucou " + prenom + "</h1>");
        writer.println("<br/>");
        writer.println("<h2> Ceci est un titre </h2>");
        writer.println("</body></html>");*/

        //Redirection vers une page jsp
        getServletContext().getRequestDispatcher("/monservlet.jsp").forward(request, response);
    }

}
