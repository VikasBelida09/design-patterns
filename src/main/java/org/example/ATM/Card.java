package org.example.ATM;

import java.util.Date;

public class Card {
    private String cardNumber;
    private String cvv;
    private String cardHolderName;
    private Date expiryDate;
    private static final Integer PIN=112233;
    private UserBankAccount userBankAccount;

    public boolean isCorrectPINEntered(int pin){
        return pin==PIN;
    }
    public int getBankBalance(){
        return userBankAccount.getTotalAmount();
    }
    public void deductBalance(int amount){
        this.userBankAccount.withdrawalBalance(amount);
    }
    public void setUserBankAccount(UserBankAccount userBankAccount){
        this.userBankAccount=userBankAccount;
    }

}
