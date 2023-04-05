package com.example.jdbc.dao;

import com.example.jdbc.model.Emploee;

import java.sql.SQLException;
import java.util.List;

public interface EmploeeDao {

    String addEmploee(String firstName, String lastName, String gender, Integer age, Integer cityId) throws SQLException;

    Emploee findById(int id) throws SQLException;

    List<Emploee> getAllEmploee() throws SQLException;

    String updateEmploee(Integer id, String firstName, String lastName, String gender, Integer age, Integer cityId) throws SQLException;

    String deleteEmploeeById(Integer id) throws SQLException;
}
