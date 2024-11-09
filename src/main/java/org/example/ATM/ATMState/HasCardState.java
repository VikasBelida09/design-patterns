package org.example.ATM.ATMState;

import org.example.ATM.ATM;
import org.example.ATM.Card;
import org.example.ATM.TransactionType;

public class HasCardState extends ATMState{
    public HasCardState() {
    }
    @Override
    public void authenticatePin(ATM atm, Card card, int pin){
        boolean isAuthenticated=card.isCorrectPINEntered(pin);
        if(isAuthenticated){
            atm.setAtmState(new SelectOperationState());
        }else{
            System.out.println("Invalid PIN Number");
            exit(atm);
        }
    }
    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }
    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }
}
