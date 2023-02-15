package database;

import domain.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountDA {

    private static ArrayList<Account> account = new ArrayList<Account>(20);

    public static void add(Account a) {
        account.add(a);
    }

    public static ArrayList<Account> getAccounts() {
        return account;
    }

    public static void initialize() {

        Account a1, a2, a3, a4;
        a1 = new AssetAccount(10001, 1001, "1-1-ac", "1-31-23", 0.5, 0.5);
        a2 = new AssetAccount(10002, 1002, "1-2-ac", "1-31-23", 0.5, 0.5);
        //int accountNumber, int customerID, String accountName, String dateOpened,double interestRate, double monthlyPayment, String paymentDate
        a3 = new LiabilityAccount(20001, 1001, "2-1-ac", "1-31-23", 0.5, 0.5, "2-4-23");
        a4 = new LiabilityAccount(20002, 1002, "2-2-ac", "1-31-23", 0.5, 0.5, "2-4-23");
        add(a1);
        add(a2);
        add(a3);
        add(a4);

    }
}
