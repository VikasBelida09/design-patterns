package org.example.ATM.ATMState;

import org.example.ATM.ATM;
import org.example.ATM.Card;
import org.example.ATM.TransactionType;

public abstract class ATMState {
    public void insertCard(ATM atm, Card card){
        System.out.println("Oops! something went wrong");
    }
    public void authenticatePin(ATM atm, Card card, int pin){
        System.out.println("Oops! something went wrong");
    }
    public void selectOperation(ATM atm, Card card, TransactionType txnType){
        System.out.println("Oops! something went wrong");
    }
    public void cashWithdrawal(ATM atm, Card card, int amount){
        System.out.println("Oops! something went wrong");
    }
    public void displayBalance(ATM atm, Card card){
        System.out.println("Oops! something went wrong");
    }
    public void returnCard(){
        System.out.println("Oops! something went wrong");
    }
    public void exit(ATM atm){
        System.out.println("Oops! something went wrong");
    }
}
