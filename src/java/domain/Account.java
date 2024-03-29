package domain;

import database.AccountDA;
import java.util.ArrayList;

public abstract class Account {

    private int accountNumber;
    private int customerID;   //this is a foreign from customer!!! no solve now
    private String accountName;
    private String dateOpened;
    private String accountType;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    

    public Account() {
    }

    public Account(int accountNumber, int customerID, String accountName, String dateOpened) {
        this.accountNumber = accountNumber;
        this.customerID = customerID;
        this.accountName = accountName;
        this.dateOpened = dateOpened;
    }

    public void add() {
        AccountDA AccountDA=new AccountDA(){};
        AccountDA.add(this);
    }

    public static ArrayList<Account> getAccounts() {
        AccountDA AccountDA=new AccountDA(){};
        return AccountDA.getAccounts();
    }

    public static void initialize() {
        AccountDA AccountDA=new AccountDA(){};
        AccountDA.initialize();
    }

    public String toString() {
        return getCustomerID() + "    " + getAccountNumber() + "    " + getAccountName();

    }

    public int getbalance() {
        System.out.println("getbalance");
                
        ArrayList<Transaction> transaction = Transaction.getTransaction();
        System.out.println(transaction);
        int i, sum;
        sum = 0;
        for (i = 0; i < transaction.size(); i++) {
            
            if (this.accountNumber == transaction.get(i).getAccountNumber()) {
                System.out.println("this is transaction"+transaction.get(i).getTransactionAmount());
                sum = sum + transaction.get(i).getTransactionAmount();
            }

        }
        
//         <input type="hidden" name="productCode" value="<c:out value='${item.code}'/>">
        return sum;

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(String dateOpened) {
        this.dateOpened = dateOpened;
    }

}
