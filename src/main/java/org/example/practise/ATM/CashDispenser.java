package org.example.practise.ATM;

import org.example.practise.ATM.CashHandler.CashHandler;
import org.example.practise.ATM.CashHandler.FiveHundredCashHandler;
import org.example.practise.ATM.CashHandler.HundredCashHandler;
import org.example.practise.ATM.CashHandler.ThousandCashHandler;

public class CashDispenser {
    private final CashHandler cashHandler;
    public CashDispenser(){
        this.cashHandler=new ThousandCashHandler();
        CashHandler fiveHundredHandler=new FiveHundredCashHandler();
        CashHandler hundredHandler=new HundredCashHandler();

        this.cashHandler.setNextClassHandler(fiveHundredHandler);
        fiveHundredHandler.setNextClassHandler(hundredHandler);
    }
    public void dispenseCash(int amount){
        cashHandler.dispense(amount);
    }
}
