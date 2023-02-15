package database;

import domain.Customer;
import java.util.ArrayList;

public class CustomerDA {

    private static ArrayList<Customer> customer = new ArrayList<Customer>(10);
    //static, everything in the daclass should be class level
    //customer is the name of arraylist

    public static void add(Customer c) {
        customer.add(c);
    }

    public static ArrayList<Customer> getCustomers() {
        return customer;
    }

    public static void initialize() {
        //set up inital instance into the table
        Customer c1;
        c1 = new Customer();
        c1.setCustomerID(1001);
        c1.setFirstName("XIANGJIE");
        c1.setLastName("QU");
        c1.setPhoneNum(5551312);
        add(c1);

        Customer c2;
        c2 = new Customer();
        c2.setCustomerID(1002);
        c2.setFirstName("JACK");
        c2.setLastName("QU");
        c2.setPhoneNum(6661312);
        add(c2);

    }
}
