package org.example.practise.ATM.States;

import org.example.practise.ATM.ATM;
import org.example.practise.ATM.Card;

public class HasCardState extends ATMState{
    public HasCardState() {
    }

    @Override
    public void authenticatePin(ATM atm, Card card, String pin) {
        boolean isAuthenticated=card.isPinEnteredCorrect(pin);
        if(isAuthenticated){
            atm.setAtmState(new SelectOperationState());
        }else{
            System.out.println("incorrect pin! please try again!");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm) {
        this.returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("exit happens!");
    }
    @Override
    public void returnCard(){
        System.out.println("please collect your card!");
    }
}
