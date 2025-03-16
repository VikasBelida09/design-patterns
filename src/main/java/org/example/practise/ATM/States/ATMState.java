package org.example.practise.ATM.States;

import org.example.practise.ATM.ATM;
import org.example.practise.ATM.Card;
import org.example.practise.ATM.TransactionType;

public abstract class ATMState {
    public void insertCard(ATM atm, Card card){
        System.out.println("Oops! something went wrong");
    }
     public void authenticatePin(ATM atm, Card card, String pin){
         System.out.println("Oops! something went wrong");
     };
    public void selectOperation(ATM atm, Card card, TransactionType type){
        System.out.println("Oops! something went wrong");
    }
    public void cashWithdrawal(ATM atm,Card card, int amount){
        System.out.println("Oops! something went wrong");
    }
    public void displayBalance(ATM atm,Card card){
        System.out.println("Oops! something went wrong");
    }
    public void returnCard(){
        System.out.println("Oops! something went wrong");
    }
    public void exit(ATM atm){
        System.out.println("Oops! something went wrong");
    }

}

/*  these are the operations
*   insert card
*   authenticate pin
*   select the operation
*   cashWithdrawal
*   displayBalance
*   returnCard
*   exit
* */


/*
*  possible states
*
* IDLE
* HAS_CARD
* SELECT_OPERATION_STATE
* CASH_WITHDRAWAL_STATE
* CHECK_BALANCE_STATE
* */
