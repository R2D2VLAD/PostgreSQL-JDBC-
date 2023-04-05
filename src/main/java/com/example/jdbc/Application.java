package com.example.jdbc;

import com.example.jdbc.dao.EmploeeDao;
import com.example.jdbc.services.EmploeeService;

import java.sql.*;

import static com.example.jdbc.connection.Connection.getConnection;

public class Application {
    public static void main(String[] args) throws SQLException {
        System.out.println("Задание 1");

        String request = "SELECT * FROM emploee WHERE id = ?";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(request);

            statement.setInt(1, 2);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString(2);
                System.out.println(firstName);
                String lastName = resultSet.getString(3);
                System.out.println(lastName);
                String gender = resultSet.getString(4);
                System.out.println(gender);
                int age = resultSet.getInt(5);
                System.out.println(age);
                int cityId = resultSet.getInt(6);
                System.out.println(cityId);
                System.out.println();
            }
        }
        System.out.println("Задание 2");
        EmploeeDao emploeeDao = new EmploeeService();
        System.out.println(emploeeDao.addEmploee("Vlad", "Житарь", "MEN", 19, 3));
        System.out.println();
        System.out.println(emploeeDao.findById(2));
        System.out.println();
        System.out.println(emploeeDao.getAllEmploee());
        System.out.println();
        System.out.println(emploeeDao.updateEmploee(3, "Vlad", "Zhitar", "MEN", 19, 5));
        System.out.println();
        System.out.println(emploeeDao.deleteEmploeeById(3));
    }
}
