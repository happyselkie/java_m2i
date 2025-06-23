package org.example.demo_bases;

import org.example.demo_bases.utils.ConnectionUtils;

import java.sql.*;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {

        Connection connection = null;
        Scanner scn = new Scanner(System.in);

        // test de connection
        try {
             connection = ConnectionUtils.getSQLConnection();

            System.out.println("Connexion établie ! ");

            System.out.println("Merci de saisir le prénom : ");
            String firstname = scn.nextLine();

            System.out.println("Merci de saisir le nom : ");
            String lastname = scn.nextLine();

            // Une requête pour l'insertion des données : PAS BIEN (attention c'est pas bien, danger d'injection SQL)
            /*String request = "INSERT INTO users (firstname, lastname) VALUES ('"+firstname+"','"+lastname+"')";
            System.out.println("Voici la requête que je vais faire : "+request);

            // Facon 1  => execution d'unerequête sans retour
            Statement statement = connection.createStatement();
            statement.execute(request);*/

            // Facon 2 avec requête préparée : BIEN

            // version sans récupération de l'id auto généré
           /* String request = "INSERT INTO users (firstname, lastname) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(request); // Recupère l'id généré

            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            //preparedStatement.execute(); // return boolean
            int rows = preparedStatement.executeUpdate(); // return int qui correspond au nbr de lignes affectées
            System.out.println("Nombre de lignes affectées : "+rows);*/

            // version avec récupération de l'id auto généré
            String request = "INSERT INTO users (firstname, lastname) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS); // Recupère l'id généré

            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);

            int rows = preparedStatement.executeUpdate(); // return int qui correspond au nbr de lignes affectées
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            System.out.println("Nombre de lignes affectées : "+rows);

            if (resultSet.next()){
                System.out.println("Dernier id inséré : " + resultSet.getInt(1));
            }


            System.out.println("Requête executée");

        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            if(connection != null){
                try{
                    connection.close();
                } catch (SQLException e){
                    System.out.println(e.getStackTrace());
                }
            }
        }






    }
}
