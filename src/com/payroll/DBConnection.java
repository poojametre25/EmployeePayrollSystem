package com.payroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Handles connection to MySQL database using JDBC
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/payroll_system";
    private static final String USER = "root";        // Your MySQL username
    private static final String PASSWORD = "7204043738"; // Your MySQL password

    // Returns a Connection object to the database
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database Connected Successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Database Connection Failed!");
            e.printStackTrace();
        }
        return connection;
    }

    // Test database connection
    public static void main(String[] args) {
        getConnection();
    }
}
