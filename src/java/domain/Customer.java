package domain;

import database.CustomerDA;
import java.util.ArrayList;
import java.util.*;
import java.io.Serializable;

public class Customer implements Serializable {

    private int customerID;
    private String firstName;
    private String lastName;
    private long phoneNum;
    private String UserID;
    private String Password;

    public Customer() {
        customerID = 0;
        firstName = "";
        lastName = "";
        phoneNum = 0;
        UserID = "";
        Password = "";

    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void add() {
        CustomerDA customerDA=new CustomerDA(){};
        customerDA.add(this);

    }

    ;
    public static ArrayList<Customer> getCustomer() {
        CustomerDA customerDA=new CustomerDA(){};
        return customerDA.getCustomers();
    }

    public static void initialize() {
        CustomerDA customerDA=new CustomerDA(){};
        customerDA.initialize();
    }

    public String toString() {

        return getCustomerID() + "    " + getFirstName();
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

}
