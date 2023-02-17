package domain;

import java.util.ArrayList;

public class BankingSystem {

    public static void main(String[] args) {
        int x, y, z;

        ArrayList<Customer> customer = Customer.getCustomer();
        ArrayList<Account> account = Account.getAccounts();
        ArrayList<Transaction> transaction = Transaction.getTransaction();
        Customer.initialize();
        Account.initialize();
        Transaction.initialize();

        //customer is an arraylist.
        for (x = 0; x < customer.size(); x++) {

            //Customer is the class of customer arraylist, so the method get is to return the string 
            //you can modify this in the  Customer class in toString method
        
            System.out.println(customer.get(x).getFirstName() + " " + "Customer infomation");
            System.out.println(customer.get(x));//customer is an arraylist,it can use "get"
            for (y = 0; y < account.size(); y++) {
                
                if (account.get(y).getCustomerID() == customer.get(x).getCustomerID()) {
                    System.out.println(customer.get(x).getFirstName() + " " + "Account infomation");
                    System.out.println(account.get(y));
                    System.out.println(customer.get(x).getFirstName() + " " + "transaction infomation");
                    for (z = 0; z < transaction.size(); z++) {

                        if (transaction.get(z).getAccountNumber() == account.get(y).getAccountNumber()) {

                            System.out.println(transaction.get(z));

                        }
                    }
                    System.out.println("the balance is ="+account.get(y).getbalance());
                    System.out.println("-----------------------------------------");
                    
                }
                
            }

            
        }

    }

}
