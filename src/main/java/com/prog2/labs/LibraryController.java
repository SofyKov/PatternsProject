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
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grech
 */
public class LibraryController 
{

    //Entities
    Librarian librarian;
    Book book;
    Student student;
    public Connection connection;

    private static LibraryController instance;

    public LibraryController() {
        try 
        {
            this.connection = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(LibraryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.book = new Book();
        this.student = new Student();
        this.librarian = new Librarian();
    }

    // Static method to get the singleton instance
    public static LibraryController getInstance()
    {
        if (instance == null) 
        {
            instance = new LibraryController();
        }
        return instance;
    }

    public void setLibrarian(Librarian librarian) 
    {
        this.librarian = librarian;
    }

    public void setStudent(Student student) 
    {
        this.student = student;
    }

    public Object createEntity(String person, String... params) 
    {
        //Factory patterns:
        Factory_LibraryEntity entityFactory = new Factory_LibraryEntity();

        System.out.println(person + " " + params[0] + " " + params.length);

        switch (person) {
            case "Librarian": //makes a Librarian
                //1st param = id
                if (params.length != 1) {
                    throw new IllegalArgumentException("Invalid number of parameters to make Librarian." + params.length);
                }
                return entityFactory.createObject(params[0]);

            //   return entityFactory.createObject(params[0]);
            case "Student": //makes a Student
                if (params.length != 3) {
                    throw new IllegalArgumentException("Invalid number of parameters to make Student." + params.length);
                }
                //student = (Student) entityFactory.createObject(params[0], params[1], params[2]);
                return entityFactory.createObject(params[0], params[1], params[2]);
            //   break;

            default:
                throw new IllegalArgumentException("Invalid entity type: " + person);
        }

    }

    public Librarian getLibrarian()
    {
        return librarian;
    }

    //move this later
    public void addBook(String SN, String title, String author, String publisher,
            float price, int quantity, int issued) 
    {
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

    public boolean verifyLogin(String id, String pw) {

        Librarian authenticate = new Librarian();

        return authenticate.verifyLogin(id, pw);
    }

    public Map<String, String> viewIssuedBooks() {

        Book getBookdb = new Book();

        //retruns all borrowed books in the db
        return getBookdb.viewissuedBooks();
    }

    public Map<String, String> viewAllBooks() {

        Book getBookdb = new Book();

        //retruns all borrowed books in the db
        System.out.println(getBookdb.viewCatalog().entrySet());
        return getBookdb.viewCatalog();
    }

    public void addBooks(String SN, String title, String author, String publisher,
            float price, int quantity, int issued) {

        Book getBookdb = new Book();

        getBookdb.addBook(SN, title, author, publisher, price, quantity, issued);

    }

    /////STUDENT


}
