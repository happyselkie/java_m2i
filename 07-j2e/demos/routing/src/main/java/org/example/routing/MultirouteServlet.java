package org.example.routing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "multirouteservlet", value = {"/multi-routes","/multi","/multi/*"})
public class MultirouteServlet extends HttpServlet {

    private List<String> prenoms;

    @Override
    public void init() throws ServletException {
        prenoms = new ArrayList<>();
        prenoms.add("John");
        prenoms.add("Janne");
        prenoms.add("Toto");
        prenoms.add("tata");
        prenoms.add("titi");
        prenoms.add("tutu");
        prenoms.add("haha");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recuperer le pathInfo avec le /
        // String pathInfo = req.getPathInfo();

        // Verification que le pathinfo a bien des information
        String pathInfo = (req.getPathInfo() != null && !req.getPathInfo().isEmpty()) ? req.getPathInfo() : "";

        String searchName = "";

        // si j'ai autre chose que "" dans mon pathinfo alors je vais recuperer les infos
        if(!pathInfo.isEmpty()){
            System.out.println("Path info obtenue : "+pathInfo);
            // pathInfo sans le / (premier caractere)
            System.out.println("path info sans le / au debut : "+pathInfo.substring(1));
            // Integer parseint pour transformer la chaine de caractere en numero
            System.out.println("path info en integer a partir d'un string "+Integer.parseInt(pathInfo.substring(1)));
            searchName = prenoms.get(Integer.parseInt(pathInfo.substring(1)));
        }


        req.setAttribute("pathInfo",pathInfo);
        req.setAttribute("prenom",searchName);
        req.getRequestDispatcher("/WEB-INF/views/route.jsp").forward(req,resp);
    }
}
