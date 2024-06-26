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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author grech
 */
public class Student implements LibraryObserver 
{
    private static Student instance;
    //LibraryController controller = LibraryController.getInstance();
    private Connection connection;
    LibraryObserver lc ;
<<<<<<< Updated upstream
    private Connection con;
=======
    private Connection con ;
>>>>>>> Stashed changes

    String sId;
    String name;
    String contact;
    
    ArrayList<ArrayList<String>> studentInfoBorrow = new ArrayList<>();
    ArrayList<String> studInfo = new ArrayList<>();

    public Student() 
    {     
        try 
        {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:sqlite:library-books.db");
            System.out.println("\nLibrary Controller: Connected to SQLite database.");
        } 
         catch (SQLException e) 
         {
            System.out.println("Error connecting to SQLite database: " + e.getMessage());
        }
    }
    
    public Student(String id, String name, String contact) 
    {
        
        this.sId = id;
        this.name = name;
        this.contact = contact;
        //this.studInfo = studInfo;
        //this.studentInfoBorrow = studentInfoBorrow;
    }

    public static synchronized Student getInstance() 
    {
        if (instance == null) {
            instance = new Student();
        }
        return instance;
    }
    
    public boolean validateStudent(String id)
    {
        boolean isExist = false;
        String sql = "SELECT * FROM Student WHERE studentID = " + id + ";";

        try (PreparedStatement statement = connection.prepareStatement(sql)) 
        {
            try (ResultSet resultSet = statement.executeQuery()) 
            {
                while (resultSet.next()) 
                {
                    String studID = resultSet.getString("studentID");
                    if(id.equals(studID))
                    {
                        isExist = true;
                    }
                }
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return isExist;
    }
    
    
    public String viewAvailableBooks() 
    {
        String sql = "SELECT * FROM Book WHERE quantity > issued;";
        String outputStr = "";

        try (PreparedStatement statement = connection.prepareStatement(sql)) 
        {
            try (ResultSet resultSet = statement.executeQuery()) 
            {
                while (resultSet.next()) 
                {
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
        } 
        catch (SQLException e) 
        {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return outputStr;
    }

    
    
    public String searchBookByBookTitle(String searchByBookTitle) 
    {
        String sql = "SELECT * FROM Book WHERE quantity > issued;";
        String outputStr = "";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
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

    public String searchBookByBookID(String searchByBookID) 
    {
        String sql = "SELECT * FROM Book WHERE quantity > issued;";
        String outputStr = "";

        try (PreparedStatement statement = connection.prepareStatement(sql)) 
        {
            try (ResultSet resultSet = statement.executeQuery()) 
            {
                while (resultSet.next()) 
                {
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
    
     public ArrayList<ArrayList<String>> findStudent(String bookID, String chosenBook, String studID)
    {
        String sql = "SELECT * FROM Student;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) 
        {
            try (ResultSet resultSet = statement.executeQuery()) 
            {
                while (resultSet.next()) 
                {
                    String id = resultSet.getString("studentID");
                    String contact = resultSet.getString("contact");
                    if(id.equals(studID))
                    {
                        String nameS = resultSet.getString("studentName");
                        studInfo.add(bookID); //0
                        studInfo.add(id); //1
                        studInfo.add(nameS); //2
                        studInfo.add(chosenBook); //3
                        studInfo.add(contact); //4
                        studentInfoBorrow.add(studInfo);
                    }
                }
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("SQL Error: " + e.getMessage());
        }
            return studentInfoBorrow;
    }
    
    public boolean didBorrowBook(ArrayList<ArrayList<String>> studentInfo)
    {
        boolean borrowed = true;
        String sql = "SELECT * FROM BorrowedBooks;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) 
        {
            try (ResultSet resultSet = statement.executeQuery()) 
            {
                while (resultSet.next()) 
                {
                    String id = resultSet.getString("student_id");
                    for(int i = 0; i < studentInfo.size(); i++)
                    {
                        if(!studentInfo.get(i).contains(id))
                        {
                            borrowed = false;
                        }
                    }
                }
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
        return borrowed;
    }
    
    public Date calculateReturnDate()
    {
        LocalDate currentDate = LocalDate.now();

        // Add 2 weeks to the current date to get the return date
        LocalDate returnDate = currentDate.plusWeeks(2);
        
        Date returnDateAsDate = java.sql.Date.valueOf(returnDate);

        // Format the dates for display
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //String returnDateStr = formatter.format(returnDate);
        
        return returnDateAsDate;
    }
    
     public boolean toReturn(Book book) 
     {
        try 
        {
            String query = "SELECT COUNT(*) FROM IssuedBooks WHERE SN = ? AND StId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, book.getSN());
            preparedStatement.setString(2, this.sId); // Assuming studentId is the primary key in Students table
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Return true if the count is greater than 0, indicating the book is issued to the student
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false by default or if an exception occurs
    }

    
    @Override
    public void update(Book book) 
    {
        System.out.println(book + "has been updated");
    }
}
