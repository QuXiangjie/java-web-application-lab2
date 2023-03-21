package database;

import domain.Account;
import domain.Customer;
import domain.Transaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionDA {

    Connection connection = DatabaseConnection.getInstance().getConnection();

    public static void initialize() {
        try {
            Transaction transaction = null;
            Connection connection = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs;
            String sql = "Select * "
                    + "from Transactions";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                transaction = new Transaction();
                transaction.setTransactionID(rs.getInt(1));
                transaction.setTransactionDate(rs.getString(2));
                transaction.setAccountNumber(rs.getInt(3));
                transaction.setDescription(rs.getString(4));
                transaction.setTransactionAmount(rs.getInt(5));
                transaction.add();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public  void add(Transaction t) {
        try {
            PreparedStatement statment = connection.prepareStatement("INSERT INTO Transactions (transactionID,transactionDate , accountNumber, description, transactionAmount) VALUES (?, ?, ?, ?, ?)");
            statment.setInt(1, t.getTransactionID());
            statment.setString(2, t.getTransactionDate());
            statment.setInt(3, t.getAccountNumber());
            statment.setString(4, t.getDescription());
            statment.setInt(5, t.getTransactionAmount());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public  ArrayList<Transaction> findTransaction(int accountNumber) {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Transactions WHERE accountNumber = ?");
            statement.setInt(1, accountNumber);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction() {};
                transaction.setTransactionID(rs.getInt(1));
                transaction.setTransactionDate(rs.getString(2));
                transaction.setAccountNumber(rs.getInt(3));
                transaction.setDescription(rs.getString(4));
                transaction.setTransactionAmount(rs.getInt(5));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return transactions;
    }

    public  ArrayList<Transaction> getTransaction() {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Transactions");
            while (rs.next()) {
                Transaction transaction= new Transaction(){};
                transaction.setTransactionID(rs.getInt(1));
                transaction.setTransactionDate(rs.getString(2));
                transaction.setAccountNumber(rs.getInt(3));
                transaction.setDescription(rs.getString(4));
                transaction.setTransactionAmount(rs.getInt(5));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return transactions;
    }

}
