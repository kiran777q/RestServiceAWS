package com.example.RestServiceAWS.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class VerifyURLPath {

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/practice";
        String username = "root";
        String password = "admin";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the MySQL database using the URL path: " + url);

            String updateNameSQL = "UPDATE practice.myfirst_practice SET name = 'Roe Smith' WHERE id = 1";
            String updateAgeSQL = "UPDATE practice.myfirst_practice SET age = 45 WHERE id = 1";
            String updateDepartmentSQL = "UPDATE practice.myfirst_practice SET department = 'Accounts' WHERE id = 1";

            Statement statement = connection.createStatement();
            statement.executeUpdate(updateNameSQL);
            statement.executeUpdate(updateAgeSQL);
            statement.executeUpdate(updateDepartmentSQL);

            System.out.println("Table updated successfully");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the MySQL database using the URL path: " + url);
            e.printStackTrace();
        }
    }
}