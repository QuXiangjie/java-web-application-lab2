package database;

import domain.*;
import database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountDA {
    Connection connection = DatabaseConnection.getInstance().getConnection();
    public  void initialize() {
        try {
            Account account = null;
            
            Statement statement = connection.createStatement();
            ResultSet rs;
            String sql = "Select * "
                    + "from Account";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                account = new Account() {
                };
                account.setAccountNumber(rs.getInt(1));
                account.setCustomerID(rs.getInt(2));
                account.setAccountName(rs.getString(3));
                account.setDateOpened(rs.getString(4));
                account.setAccountType(rs.getString(5));
                account.add();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public  void add(Account a) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Account (AccountNumber, CustomerID, AccountName, DateOpened, AccountType) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, a.getAccountNumber());
            statement.setInt(2, a.getCustomerID());
            statement.setString(3, a.getAccountName());
            statement.setString(4, a.getDateOpened());
            statement.setString(5, a.getAccountType());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public  ArrayList<Account> getAccounts() {
        ArrayList<Account> accounts = new ArrayList<Account>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Account");
            while (rs.next()) {
                Account account = new Account() {};
                account.setAccountNumber(rs.getInt("AccountNumber"));
                account.setCustomerID(rs.getInt("CustomerID"));
                account.setAccountName(rs.getString("AccountName"));
                account.setDateOpened(rs.getString("DateOpened"));
                account.setAccountType(rs.getString("AccountType"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accounts;
    }

    public  ArrayList<Account> findAccount(int customerID) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Account WHERE CustomerID = ?");
            statement.setInt(1, customerID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account account = new Account() {};
                account.setAccountNumber(rs.getInt("AccountNumber"));
                account.setCustomerID(rs.getInt("CustomerID"));
                account.setAccountName(rs.getString("AccountName"));
                account.setDateOpened(rs.getString("DateOpened"));
                account.setAccountType(rs.getString("AccountType"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accounts;
    }
}

