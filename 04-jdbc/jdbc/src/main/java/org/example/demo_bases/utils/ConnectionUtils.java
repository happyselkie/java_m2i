package org.example.demo_bases.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getSQLConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/demo_jdbc";
        String username = "root";
        String pass = "franfran";

        Connection connection = DriverManager.getConnection(url, username, pass);
        return connection;
    }
}
