package org.example.ATM.ATMState;

import org.example.ATM.ATM;
import org.example.ATM.Card;

public class IdleState extends ATMState{
    public IdleState() {
    }

    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("Card is inserted");
        atm.setAtmState(new HasCardState());
    }
}
