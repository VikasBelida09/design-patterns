package org.example.ATM.ATMState;

import org.example.ATM.ATM;
import org.example.ATM.Card;

public class CashWithdrawalState extends ATMState{
    public CashWithdrawalState() {
        System.out.println("Please enter the Withdrawal Amount");
    }
    @Override
    public void cashWithdrawal(ATM atm, Card card, int amount){
        if(atm.getAtmBalance() < amount){
            System.out.println("Insufficient funds in the ATM Machine");
            exit(atm);
        }
        else if(card.getBankBalance() < amount){
            System.out.println("Insufficient funds in the card");
            exit(atm);
        }else{
            card.deductBalance(amount);
            atm.deductATMBalance(amount);

            //using chain of responsibility for this logic
            exit(atm);
        }
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
