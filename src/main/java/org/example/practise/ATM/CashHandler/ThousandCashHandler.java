package org.example.practise.ATM.CashHandler;

public class ThousandCashHandler extends CashHandler{
    @Override
    public void dispense(int amount) {
        if(amount>=1000){
            int cnt=amount/1000;
            int bal=amount %1000;
            System.out.println("dispensing : "+cnt+" 1000 notes");
            if(bal!=0 && nextClassHandler!=null){
                this.nextClassHandler.dispense(bal);
            }
        }else if(nextClassHandler!=null){
            this.nextClassHandler.dispense(amount);
        }
    }
}
