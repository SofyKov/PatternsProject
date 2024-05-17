/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author grech
 */
public class Librarian implements LibraryObserver {

    private String id;
    private Connection connection;

    public Librarian() {
        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:sqlite:library-books.db");
            System.out.println("\nLibrary Controller: Connected to SQLite database.");
        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite database: " + e.getMessage());
        }
    }

    public Librarian(String id) {
        this.id = id;
    }

    // Method to verify login credentials for both librarians and students
    public boolean verifyLogin(String id, String password) {

        String sql = "SELECT * FROM Librarian WHERE ID = ? AND passwd = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Return true if there's a matching record
            }
        } catch (SQLException e) {
            System.out.println("Error verifying login: " + e.getMessage());
        }

        return false; // Return false if an error occurs or no matching record found
    }

    //OBSERVER
    @Override
    public void update(Book book) {
        System.out.println(book + "has been updated");
    }

}
