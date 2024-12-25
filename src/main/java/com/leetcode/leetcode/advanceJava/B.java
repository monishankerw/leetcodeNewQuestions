package com.leetcode.leetcode.advanceJava;

import java.sql.*;

public class B {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/author?useSSL=false&serverTimezone=UTC";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "12Rose#2323";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            // Perform CRUD operations
            createTable(connection);
            insertData(connection, 1, "VarshaMani");
            insertData(connection, 2, "MoniShanker");
            readData(connection);
            updateData(connection, 2, "ShankerMoni");
            deleteData(connection, 1);
            readData(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create Table
    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS maniShanker (id INT PRIMARY KEY, name VARCHAR(50))";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table created or already exists.");
        }
    }

    // Insert Data
    private static void insertData(Connection connection, int id, String name) throws SQLException {
        String insertSQL = "INSERT INTO maniShanker (id, name) VALUES (?, ?) ON DUPLICATE KEY UPDATE name = VALUES(name)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows inserted/updated: " + rowsAffected);
        }
    }

    // Read Data
    private static void readData(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM maniShanker";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            System.out.println("Table data:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }
        }
    }

    // Update Data
    private static void updateData(Connection connection, int id, String newName) throws SQLException {
        String updateSQL = "UPDATE maniShanker SET name = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows updated: " + rowsAffected);
        }
    }

    // Delete Data
    private static void deleteData(Connection connection, int id) throws SQLException {
        String deleteSQL = "DELETE FROM maniShanker WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows deleted: " + rowsAffected);
        }
    }
}