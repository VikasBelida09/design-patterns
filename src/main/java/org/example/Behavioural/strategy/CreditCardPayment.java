package org.example.Behavioural.strategy;

public class CreditCardPayment implements PaymentStrategy{
    private String cardNumber;
    private String cvc;
    public CreditCardPayment(String cardNumber, String cvc){
        this.cardNumber=cardNumber;
        this.cvc=cvc;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Payment made using "+amount+" Credit card ending with"+ cardNumber.substring(cardNumber.length()-5));
    }
}
