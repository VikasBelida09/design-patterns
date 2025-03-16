package org.example.Splitwise;

import java.util.Date;

public class Payment {
    User payer;
    User payee;
    double amnt;
    Date transactionDate;
    String payerComments;

    Payment(User payer, User payee, double amnt, String payerComments){
        this.payee=payee;
        this.payer=payer;
        this.amnt=amnt;
        this.payerComments=payerComments;
        transactionDate=new Date();
    }
    public void makePayment(){
        payer.updateBalance(payee, amnt);
        payee.updateBalance(payer, -amnt);
    }
}
