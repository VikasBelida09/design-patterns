package org.example.practise.ATM.States;


import org.example.practise.ATM.ATM;
import org.example.practise.ATM.Card;

public class CheckBalanceState extends ATMState {
    public CheckBalanceState() {
    }

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your account balance is: " + card.getBankAccount().getBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
