package org.example.ATM.AmountWithdrawal;

import org.example.ATM.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawalProcessor{
    public OneHundredWithdrawProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }
    public void withdraw(ATM atm, int remainingAmount){
        int required=remainingAmount/100;
        int balance=remainingAmount%100;
        if(required<= atm.getNoOfHundreds()){
            atm.deductOneHundredNotes(required);
        }else if(required > atm.getNoOfHundreds()){
            atm.deductOneHundredNotes(atm.getNoOfHundreds());
            balance=balance+(required - atm.getNoOfHundreds())*100;
        }
        if (balance!=0){
            System.out.println("Something went wrong");
        }
    }
}
