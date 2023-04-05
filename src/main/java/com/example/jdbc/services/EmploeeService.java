package com.example.jdbc.services;

import com.example.jdbc.dao.EmploeeDao;
import com.example.jdbc.model.City;
import com.example.jdbc.model.Emploee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.jdbc.connection.Connection.getConnection;

public class EmploeeService implements EmploeeDao {

    @Override
    public String addEmploee(String firstName, String lastName, String gender, Integer age, Integer cityId) throws SQLException {
        String str1 = "INSERT INTO emploee (first_name, last_name, gender, age, city_id) VALUES (?,?,?,?,?)";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(str1);

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setInt(4, age);
            statement.setInt(5, cityId);
            statement.executeUpdate();
        }
        return "Участник успешно добавлен!";
    }

    @Override
    public Emploee findById(int id) throws SQLException {
        String str2 = "SELECT * FROM emploee WHERE id=(?)";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(str2);

            statement.setInt(1, id);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            return new Emploee(
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    findByIdCity(resultSet.getInt(6)));
        }
    }

    @Override
    public List<Emploee> getAllEmploee() throws SQLException {
        String str3 = "SELECT * FROM emploee";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(str3)) {

            List<Emploee> emploees = new ArrayList<>();
            while (resultSet.next()) {
                emploees.add(new Emploee(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        findByIdCity(resultSet.getInt(6))));
            }
            return emploees;
        }
    }

    @Override
    public String updateEmploee(Integer id, String firstName, String lastName, String gender, Integer age, Integer cityId) throws SQLException {
        String str4 = "UPDATE emploee SET first_name = ?, last_name = ?, gender = ?, age = ?, city_id = ? WHERE id = (?)";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(str4);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setInt(4, age);
            statement.setInt(5, cityId);
            statement.setInt(6, id);
            statement.executeUpdate();
        }
        return "Участник успешно изменен!";
    }

    @Override
    public String deleteEmploeeById(Integer id) throws SQLException {
        String str5 = "DELETE FROM emploee WHERE id =(?)";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(str5);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        return "Участник успешно удален!";
    }

    private City findByIdCity(Integer id) throws SQLException {
        String str = "SELECT * FROM city WHERE city_id=(?)";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(str);

            statement.setInt(1, id);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            return new City(resultSet.getString("city_name"));
        }
    }
}
