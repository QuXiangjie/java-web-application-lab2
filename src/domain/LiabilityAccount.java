/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author 0837099
 */

public class LiabilityAccount extends Account {
    private double interestRate;
    private double monthlyPayment;
    private String paymentDate;

    public LiabilityAccount() {}
    public LiabilityAccount(int accountNumber, int customerID, String accountName, String dateOpened,
                            double interestRate, double monthlyPayment, String paymentDate) {
        super(accountNumber, customerID, accountName, dateOpened);
        this.interestRate = interestRate;
        this.monthlyPayment = monthlyPayment;
        this.paymentDate = paymentDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
