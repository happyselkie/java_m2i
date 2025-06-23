package org.example.exercices_bases;

import org.example.demo_bases.utils.ConnectionUtils;
import org.example.exercices_bases.utils.DatabaseManager;
import org.example.exercices_bases.utils.Ihm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;

        try{
            connection = new DatabaseManager().getConnection();

            Ihm imh = new Ihm(connection);
            imh.start();

        } catch (SQLException e){
            System.out.println("la connexion a échoué: "+ e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Ce n'est pas le bon input : " + e.getMessage());
        } finally {
            try{
                connection.close();
            } catch (SQLException e){
                System.out.println("La fermeture de la connexion a échoué : "+e.getMessage());
            }
        }
    }
}
