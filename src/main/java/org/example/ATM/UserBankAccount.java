package org.example.ATM;

public class UserBankAccount {
    private int totalAmount;
    private int accountNumber;

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public UserBankAccount(int totalAmount, int accountNumber) {
        this.totalAmount = totalAmount;
        this.accountNumber=accountNumber;
    }
    public void withdrawalBalance(int  amount){
        this.totalAmount=this.totalAmount-amount;
    }
}
