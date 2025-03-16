package org.example.practise.ATM.States;

import org.example.practise.ATM.ATM;
import org.example.practise.ATM.Card;

public class IdleState extends ATMState{
   public IdleState(){

   }
   @Override
   public void insertCard(ATM atm, Card card){
      atm.setAtmState(new HasCardState());
       System.out.println("Please insert the card!");
   }
}
