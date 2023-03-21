package database;

import domain.Account;
import domain.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

public class CustomerDA {

    Connection connection = DatabaseConnection.getInstance().getConnection();

    public void initialize() {

        try {
            Customer customer = null;

            Statement statement = connection.createStatement();
            ResultSet rs;
            String sql = "Select * "
                    + "from Customer";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                customer = new Customer();
                customer.setCustomerID(rs.getInt(1));
                customer.setFirstName(rs.getString(2));
                customer.setLastName(rs.getString(3));
                customer.setPhoneNum(rs.getLong(4));
                customer.setUserID(rs.getString(5));
                customer.setPassword(rs.getString(6));

                customer.add();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void add(Customer c) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Customer (customerID, firstName, lastName, phoneNum, UserID, Password) VALUES (?, ?, ?, ?, ?,?)");
            statement.setInt(1, c.getCustomerID());
            statement.setString(2, c.getFirstName());
            statement.setString(3, c.getLastName());
            statement.setLong(4, c.getPhoneNum());
            statement.setString(5, c.getUserID());
            statement.setString(6, c.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Customer");
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rs.getInt(1));
                customer.setFirstName(rs.getString(2));
                customer.setLastName(rs.getString(3));
                customer.setPhoneNum(rs.getLong(4));
                customer.setUserID(rs.getString(5));
                customer.setPassword(rs.getString(6));
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customers;
    }

    public Customer findCustomer(String userId) {
    Customer customer = new Customer();
    System.out.println("this is login customerfinded");
    try {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customer WHERE UserID = ?");
        statement.setString(1, userId);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
        customer.setCustomerID(rs.getInt(1));
        customer.setFirstName(rs.getString(2));
        customer.setLastName(rs.getString(3));
        customer.setPhoneNum(rs.getLong(4));
        customer.setUserID(rs.getString(5));
        customer.setPassword(rs.getString(6));
        }
        
        System.out.println("this is login customerfinded");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return customer;
}

}
