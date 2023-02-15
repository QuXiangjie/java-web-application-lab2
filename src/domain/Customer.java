
package domain;

import database.CustomerDA;
import java.util.ArrayList;


public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private long phoneNum;
    
    public void add(){
      CustomerDA.add(this);
      
    };
    public static ArrayList<Customer>getCustomer(){
       return CustomerDA.getCustomers();
    }
    public static void initialize(){
           CustomerDA.initialize();
    }
    public String toString(){
        
    return getCustomerID()+"    "+getFirstName();
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
