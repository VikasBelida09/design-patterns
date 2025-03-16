package org.example.practise.ATM.States;

import org.example.practise.ATM.ATM;
import org.example.practise.ATM.Card;

public class CashWithdrawalState extends ATMState{
    public CashWithdrawalState() {
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int amount) {
          if(atm.getAtmBalance() < amount){
              System.out.println("Insufficient funds!");
              return;
          }
          if(card.getBankAccount().getBalance() < amount){
              System.out.println("Insufficient funds in the account");
          }else{
              card.deductBalance(amount);
              atm.deductATMBalance(amount);
              atm.dispenseCash(amount);
              exit(atm);
          }

    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("exit happens here!!");
    }

    @Override
    public void returnCard() {
        System.out.println("please collect your card");
    }
}
