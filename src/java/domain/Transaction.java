package domain;

import database.TransactionDA;
import java.util.ArrayList;

public class Transaction {

    private int transactionID;
    private String transactionDate;
    private int accountNumber;   //this is a foreign from customer!!! no solve now
    private String description;
    private int transactionAmount;

    public Transaction() {
    }

    public Transaction(int transactionID, String transactionDate, int accountNumber, String description, int transactionAmount) {
        this.accountNumber = accountNumber;
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.accountNumber = accountNumber;   //this is a foreign from customer!!! no solve now
        this.description = description;
        this.transactionAmount = transactionAmount;
    }

    public void add() {
        TransactionDA.add(this);

    }

    ;
    public static ArrayList<Transaction> getTransaction() {
        return TransactionDA.getTransaction();
    }

    public static void initialize() {
        TransactionDA.initialize();
    }

    public String toString() {
        return getTransactionID() + "    "+getTransactionDate() + "    " +getAccountNumber() + "    " +getDescription() + "    "  + getTransactionAmount();
    }

    public int getTransactionID() {
        return transactionID;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

}
