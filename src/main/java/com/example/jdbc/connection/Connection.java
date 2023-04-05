package com.example.jdbc.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public static java.sql.Connection getConnection() throws SQLException {
        final String url = "jdbc:postgresql://localhost:5433/skypro";
        final String username = "postgres";
        final String password = "1234";
        return DriverManager.getConnection(url, username, password);
    }
}
