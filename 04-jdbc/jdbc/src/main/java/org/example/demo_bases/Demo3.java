package org.example.demo_bases;

import org.example.demo_bases.utils.ConnectionUtils;

import java.sql.*;

public class Demo3 {
    public static void main(String[] args) {
        // recuperation des données
        Connection connection = null;
        String request = "SELECT  * FROM users";
        String request2 = "SELECT  * FROM users WHERE id = ?";

        try{
            connection = ConnectionUtils.getSQLConnection();

            // non préparée
            /*Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);

             while (resultSet.next()){
                System.out.println("La colonne id : "+resultSet.getInt("id"));
                System.out.println("La colonne firstname : "+resultSet.getString("firstname"));
                System.out.println("La colonne lastname : "+resultSet.getString("lastname"));
            }

            */

            // préparée
            PreparedStatement statement = connection.prepareStatement(request2);
            statement.setInt(1, 3);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                System.out.println("La personne avec l'id numéro 3 : ");
                System.out.println("Son nom : "+resultSet.getString("lastname"));
                System.out.println("Son prénom : "+resultSet.getString("firstname"));
            }




        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try{
                connection.close();
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
