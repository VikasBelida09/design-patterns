package org.example.test.BookMyShow.Payment;

public class CreditCard implements Payment{
    private String cardNumber;
    private String cvc;
    private String validTill;

    public CreditCard( String cardNumber,  String cvc,  String validTill){
        this.cardNumber=cardNumber;
        this.cvc=cvc;
        this.validTill=validTill;
    }
    @Override
    public boolean processPayment(double price) {
        System.out.println("Payment: "+price+" made using Ccard ending :"+ cardNumber.substring(cardNumber.length()-4));
        return true;
    }
}
