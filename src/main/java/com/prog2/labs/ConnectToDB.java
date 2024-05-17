/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ConnectToDB 
{
    public Connection connectDB()
    {
        Connection con = null;
        try 
        {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
            System.out.println("Connection Successful");
            JOptionPane.showMessageDialog(null, "Connection Successful"+con);
        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println("SQLite JDBC Driver not found");
            JOptionPane.showMessageDialog(null, "SQLite JDBC Driver not found");
            e.printStackTrace();
        } 
        catch (SQLException e) 
        {
            System.out.println("Connection failed: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Connection failed");
            e.printStackTrace();
        }
        return con;
    }
}       
