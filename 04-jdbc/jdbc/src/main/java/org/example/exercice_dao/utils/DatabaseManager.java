package org.example.exercice_dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private final String URI = "jdbc:mysql://localhost:3306/bank";
    private final String USER = "root";
    private final String PASSWORD = "franfran";

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URI,USER,PASSWORD);
    }
}
