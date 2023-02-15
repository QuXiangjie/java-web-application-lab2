
package domain;


public class AssetAccount extends Account {
    private double interestRate;
    private double transactionFee;
    
    public AssetAccount() {}
    public AssetAccount(int accountNumber, int customerID, String accountName, String dateOpened,
                        double interestRate, double transactionFee) {
        super(accountNumber, customerID, accountName, dateOpened);
        this.interestRate = interestRate;
        this.transactionFee = transactionFee;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }
}

