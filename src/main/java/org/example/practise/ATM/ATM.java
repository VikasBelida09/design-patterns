package org.example.practise.ATM;

import org.example.practise.ATM.States.ATMState;
import org.example.practise.ATM.States.IdleState;

public class ATM {
    ATMState atmState;
    private int atmBalance;
    private static volatile ATM atmInstance;
    private final CashDispenser cashDispenser;
    private ATM(){
        this.cashDispenser=new CashDispenser();
        this.atmBalance=10000000;
        atmState=new IdleState();
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public void deductATMBalance(int amount) {
        this.atmBalance-=amount;
    }
    public static ATM getATMObject(){
       if(atmInstance==null){
           synchronized (ATM.class){
               if(atmInstance==null){
                   atmInstance=new ATM();
               }
           }
       }
       return atmInstance;
    }
    public void dispenseCash(int amnt){
        this.cashDispenser.dispenseCash(amnt);
    }
    public void insertCard(Card card){
        atmState.insertCard(this, card);
    }
    public void authenticatePin(Card card, String pin){
        atmState.authenticatePin(this, card, pin);
    }
    public void selectOperation(Card card, TransactionType type){
        atmState.selectOperation(this,card, type );
    }
    public void exit(){
        atmState.exit(this);
    }
    public void returnCard(){
        atmState.returnCard();
    }
    public void cashWithdraw(Card card, int amnt){
        atmState.cashWithdrawal(this, card, amnt);
    }
    public void checkCashBalance(Card card){
        atmState.displayBalance(this, card);
    }
}
