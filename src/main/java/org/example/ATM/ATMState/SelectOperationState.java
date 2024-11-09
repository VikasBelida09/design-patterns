package org.example.ATM.ATMState;

import org.example.ATM.ATM;
import org.example.ATM.Card;
import org.example.ATM.TransactionType;

public class SelectOperationState extends ATMState {
    public SelectOperationState() {
    }
    @Override
    public void selectOperation(ATM atm, Card card, TransactionType type){
        switch (type) {
            case CASH_WITHDRAWAL -> atm.setAtmState(new CashWithdrawalState());
            case BALANCE_CHECK -> atm.setAtmState(new CheckBalanceState());
            default -> {
                System.out.println("Invalid Option");
                exit(atm);
            }
        }

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
