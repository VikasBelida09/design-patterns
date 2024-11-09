package org.example.ATM.ATMState;

import org.example.ATM.ATM;
import org.example.ATM.Card;

public class CheckBalanceState extends ATMState{
    public CheckBalanceState() {
    }
    @Override
    public void displayBalance(ATM atm, Card card){
        System.out.println("current ammount in the your account: "+card.getBankBalance());
        exit(atm);
    }
    @Override
    public void exit(ATM atmObject){
        returnCard();
        atmObject.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }

}
