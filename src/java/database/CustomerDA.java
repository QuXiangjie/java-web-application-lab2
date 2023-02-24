package database;

import domain.Customer;
import java.util.ArrayList;
import java.util.HashSet;

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

    public Customer getCustomer(ArrayList <Customer> customers,String userId) {
       

        for (Customer customer1 : customers) {
            if (customer1.getUserID().equals(userId)) {
                System.out.println("there is an user");
                return customer1;
            }
        }
        return null;
    }

    public static void initialize() {
        //set up inital instance into the table
        Customer c1;
        c1 = new Customer();
        c1.setCustomerID(1001);
        c1.setFirstName("XIANGJIE");
        c1.setLastName("QU");
        c1.setPhoneNum(5551312);
        c1.setUserID("Cust1");
        c1.setPassword("cust1");
        add(c1);

        Customer c2;
        c2 = new Customer();
        c2.setCustomerID(1002);
        c2.setFirstName("JACK");
        c2.setLastName("QU");
        c2.setPhoneNum(6661312);
        c2.setUserID("Cust2");
        c2.setPassword("cust2");
        add(c2);

        Customer c3;
        c3 = new Customer();
        c3.setCustomerID(1003);
        c3.setFirstName("Anthony");
        c3.setLastName("Tang");
        c3.setPhoneNum(7771312);
        c3.setUserID("Cust3");
        c3.setPassword("cust3");

        add(c3);

    }
}
