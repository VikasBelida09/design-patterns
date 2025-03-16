package org.example.practise.ATM.CashHandler;

public class FiveHundredCashHandler extends CashHandler{

    @Override
    public void dispense(int amount) {
        if(amount>=500){
            int cnt=amount/500;
            int bal=amount %500;
            System.out.println("dispensing :"+cnt+" 500 notes");
            if(bal!=0 && nextClassHandler!=null){
                this.nextClassHandler.dispense(bal);
            }
        }else if(nextClassHandler!=null){
            this.nextClassHandler.dispense(amount);
        }
    }
}
