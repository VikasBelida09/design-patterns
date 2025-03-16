package org.example.practise.ATM.CashHandler;

public abstract class CashHandler {
    protected CashHandler nextClassHandler;
    public CashHandler(){
    }
    public abstract void dispense(int amount);
    public void setNextClassHandler(CashHandler handler){
        this.nextClassHandler=handler;
    }
}
