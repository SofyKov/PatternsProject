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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OBSERVABLE
 *
 * @author grech
 */
public class Book {

    List<LibraryObserver> observers;

    String SN;
    String title;
    String author;
    String publisher;
    float price;
    int quantity;
    int issued;
    Date addedDate;

    private Connection connection;

    public Book() {
        this.observers = new ArrayList<>();

        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:sqlite:library-books.db");
            System.out.println("\nBook: Connected to SQLite database.");
        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite database: " + e.getMessage());
        }

    }

    public Book(String SN, String title, String author, String publisher, float price, int quantity) {
        this.SN = SN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.quantity = quantity;
        this.issued = 0;
        this.addedDate = addedDate;
        this.observers = new ArrayList<>();
    }

    //Setters
    public void setSN(String SN) {
        this.SN = SN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIssued(int issued) {
        this.issued = issued;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    //Getters
    public String getSN() {
        return SN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIssued() {
        return issued;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    //////////////////// OBSERVER DESIGN PATTERN
    public void addObserver(LibraryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LibraryObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        //notifies observers when a book is return/borrowed
        for (LibraryObserver observer : observers) {
            observer.update(this);
        }
    }

    //////////////////////////////////DATABSE QUERIE///////////////////////
    public Map<String, String> viewCatalog() {
        Map<String, String> catalog = new HashMap<>();
        String sql = "SELECT * FROM Book";

        try (PreparedStatement statement = connection.prepareStatement(sql); 
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                // Retrieve book information from the result set
                String sn = resultSet.getString("sn");
                String t = resultSet.getString("title");
                String a = resultSet.getString("author");
                String ps = resultSet.getString("publisher");
                Float pr = resultSet.getFloat("price");
                int qu = resultSet.getInt("quantity");
                int is = resultSet.getInt("issued");
                Date ad = resultSet.getDate("addedDate");

                // Format the book details into a single string
                String details = String.format("Author: %s\nPublisher: %s\nSN: %s\nPrice: %.2f\nQuantity: %d\nIssued: %d\nAdded Date: %s",
                        a, ps, sn, pr, qu, is, ad.toString());

                // Put the title and details into the map
                catalog.put(t, details);
            }
            if(catalog.isEmpty()){
                System.out.println("Cannot be found");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return catalog;
    }

    public Map<String, String> viewissuedBooks() {
        Map<String, String> catalog = new HashMap<>();

        String sql = "SELECT * FROM IssuedBooks";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Retrieve borrowed books information from the result set
                    String id = resultSet.getString("id");
                    String sn = resultSet.getString("sn");

                    String stid = resultSet.getString("studentId");
                    String stName = resultSet.getString("studentName");

                    String c = resultSet.getString("contact");
                    String idate = resultSet.getString("issuedate");

                    // Format the book details
                    String formattedDetails = String.format("| ID: %-5s | Student ID: %-10s | Student Name: %-10s | Contact: %-5s | Issue Date: %-5s | "
                            + "Issued: %-5f | Added Date: %-5s |", id, stid, stName, c, idate.toString());

                    // Put the formatted details into the catalog map with title as the key
                    catalog.put(sn, formattedDetails);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return catalog;
    }

    public void addBook(String SN, String title, String author, String publisher,
            float price, int quantity, int issued) {
        Book book = new Book(SN, title, author, publisher, price, quantity);

        String query = "select * from book.book";

        try {
            Calendar calendar = Calendar.getInstance();
            java.sql.Date currDate = new java.sql.Date(calendar.getTime().getTime());

            String sql = "insert into book (SN, title, author, publisher ,price, quantity, issued, addedDate) values (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(0, SN);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, publisher);
            ps.setFloat(4, price);
            ps.setInt(5, quantity);
            ps.setInt(6, 0);

            LocalDateTime currentTime = LocalDateTime.now();

            // Define a custom date-time format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Format the current time using the custom format
            String formattedTime = currentTime.format(formatter);

            ps.setString(7, formattedTime);

            // Step 6: Process the results
            ps.execute();
            connection.close();
            System.out.println(ps.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
