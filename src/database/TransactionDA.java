package database;

import domain.Account;
import domain.Transaction;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionDA {

    private static ArrayList<Transaction> transaction = new ArrayList<Transaction>(20);

    public static void add(Transaction t) {
        transaction.add(t);
    }

    public static ArrayList<Transaction> getTransaction() {
        return transaction;
    }

    public static void initialize() {
        Transaction t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;    //creat 12 objects for 4 accounts for 2 customer

        t1 = new Transaction(1, "2-4-23", 10001, "1001 assetaccount transaction", 10);
        t2 = new Transaction(2, "2-3-23", 10001, "1001 assetaccount transaction", 11);
        t3 = new Transaction(3, "2-2-23", 10001, "1001 assetaccount transaction", 12);
        t4 = new Transaction(4, "2-1-23", 10002, "1002 assetaccount transaction", 13);
        t5 = new Transaction(5, "1-31-23", 10002, "1002 assetaccount transaction", 14);
        t6 = new Transaction(6, "1-31-23", 10002, "1002 assetaccount transaction", 15);
        t7 = new Transaction(7, "2-3-23", 20001, "2001 liabilityaccount transaction", 16);
        t8 = new Transaction(8, "2-2-23", 20001, "2001 liabilityaccount transaction", 17);
        t9 = new Transaction(9, "2-1-23", 20001, "2001 liabilityaccount transaction", 18);
        t10 = new Transaction(10, "1-31-23", 20002, "2002 liabilityaccount transaction", 19);
        t11 = new Transaction(11, "1-31-23", 20002, "2002 liabilityaccount transaction", 20);
        t12 = new Transaction(12, "2-4-23", 20002, "2002 liabilityaccount transaction", 21);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(t7);
        add(t8);
        add(t9);
        add(t10);
        add(t11);
        add(t12);
    }

}
