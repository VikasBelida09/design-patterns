package org.example.practise.ATM.States;

import org.example.practise.ATM.ATM;
import org.example.practise.ATM.Card;
import org.example.practise.ATM.TransactionType;

public class SelectOperationState extends ATMState{
    public SelectOperationState() {
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType type) {
        switch (type){
            case CASH_WITHDRAWAL -> atm.setAtmState(new CashWithdrawalState());
            case BALANCE_CHECK -> atm.setAtmState(new CheckBalanceState());
            default -> {
                System.out.println("invalid operation");
            }
        }
    }

    @Override
    public void returnCard() {
        System.out.println("please collect your card!");
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("exit happens!");
    }
}



/*
*  objective of state pattern is to move system from one state to another state cleanly any operation we do it has to move the system into a state
* */