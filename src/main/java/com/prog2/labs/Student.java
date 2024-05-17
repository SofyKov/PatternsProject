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
public class Student implements LibraryObserver {

    private Connection con;

    String sId;
    String name;
    String contact;

    public Student(String id, String name, String contact) {
        
        this.sId = id;
        this.name = name;
        this.contact = contact;
                
    }

    public String viewAvailableBooks() {
        String sql = "SELECT * FROM Book WHERE quantity > issued;";
        String outputStr = null;

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Retrieve patient information from the result set
                    String sn = resultSet.getString("sn");
                    outputStr += sn + " | ";

                    String t = resultSet.getString("title");
                    outputStr += t + " | ";

                    String a = resultSet.getString("author");
                    outputStr += a + "\n";

                    System.out.println(sn + " " + t + " " + a);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return outputStr;
    }

    public String searchBookByBookID(String searchByBookTitle) {
        String sql = "SELECT * FROM Book WHERE quantity > issued;";
        String outputStr = "";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Retrieve book information from the result set
                    String t = resultSet.getString("title");

                    if (searchByBookTitle.equalsIgnoreCase(t)) {
                        outputStr += t + " ";

                        String title = resultSet.getString("author");
                        outputStr += "by " + title;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        System.out.println(outputStr);
        return outputStr;
    }

    public String searchBookByBookTitle(String searchByBookID) {
        String sql = "SELECT * FROM Book WHERE quantity > issued;";
        String outputStr = "";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Retrieve book information from the result set
                    String sn = resultSet.getString("sn");

                    if (searchByBookID.equalsIgnoreCase(sn)) {
                        String t = resultSet.getString("title");
                        outputStr += t + " ";

                        String title = resultSet.getString("author");
                        outputStr += "by " + title;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        System.out.println(outputStr);
        return outputStr;
    }

    @Override
    public void update(Book book) {
        System.out.println(book + "has been updated");
    }
}
