package org.example.practise.ATM.CashHandler;

public class HundredCashHandler extends CashHandler{

    @Override
    public void dispense(int amount) {
        if(amount>=100){
            int cnt=amount/100;
            int bal=amount %100;
            System.out.println("dispensing :"+cnt+" 100 notes");
            if(bal!=0 && nextClassHandler!=null){
                this.nextClassHandler.dispense(bal);
            }
        }else{
            System.out.println("Cannot dispense remaining amount: " + amount);
        }
    }
}
