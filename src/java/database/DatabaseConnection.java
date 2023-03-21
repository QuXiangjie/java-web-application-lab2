package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private Connection connection = null;
    
    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/BankingSystemDB", "CIS640", "cis640");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return connection;
    }
}