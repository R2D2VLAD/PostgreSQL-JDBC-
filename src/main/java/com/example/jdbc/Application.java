package com.example.jdbc;

import com.example.jdbc.model.City;
import com.example.jdbc.model.Emploee;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        String request = "SELECT * FROM emploee WHERE id = 2";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(request)) {

            while (resultSet.next()) {
                Emploee emploee = new Emploee();
                City city = new City();
                city.setCityName(resultSet.getString(2));
                emploee.setFirstname(resultSet.getString(2));
                emploee.setLastname(resultSet.getString(3));
                emploee.setGender(resultSet.getString(4));
                emploee.setAge(resultSet.getInt(5));
                emploee.setCityId(city);
                System.out.println(emploee);
            }
        }
    }

    private static Connection getConnection() throws SQLException {
        final String url = "jdbc:postgresql://localhost:5433/skypro";
        final String username = "postgres";
        final String password = "1234";
        return DriverManager.getConnection(url, username, password);
    }
}
