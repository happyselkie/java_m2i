package org.example.demo_bases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo1 {
    public static void main(String[] args) {

        // 1 Création nouveau projet :
        // File => new => projet => Build System : maven

        // 2 Ajouter les dependencies maven

        // 3 ajouter le connecteur correspondant à ma BD


        // Préparation pour se connecter à ma BDD

        String url = "jdbc:mysql://localhost:3306/demo_jdbc";
        String username = "root";
        String pass = "franfran";

        try{
            Connection connection = DriverManager.getConnection(url, username, pass);
            if(connection != null) System.out.println("La connexion est OK !!");
        } catch (SQLException e){
            System.out.println("La Connexion a échoué : "+e.getMessage());
        }

        // Meilleure ratique : mettre la connexion dans une classe à part
        // Voir ConnectionUtils et Demo2

    }
}
