package org.example.ATM.AmountWithdrawal;

import org.example.ATM.ATM;

public abstract class CashWithdrawalProcessor {
 CashWithdrawalProcessor nextCashWithdrawalProcessor;
 CashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor){
     this.nextCashWithdrawalProcessor=cashWithdrawalProcessor;
 }
 public void withdraw(ATM atm, int remainingAmount){
     if(nextCashWithdrawalProcessor!=null){
         nextCashWithdrawalProcessor.withdraw(atm,remainingAmount);
     }
 }
}