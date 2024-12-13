package org.example.test.FoodDeliverySystem.Payment;

public class CreditCard implements Payment{
    private String cardNumber;
    private String cvc;
    private String expiry;


    @Override
    public boolean makePayment(double price) {
        System.out.println("Payment:"+price+" made using card ending with: "+ cardNumber.substring(cardNumber.length()-4));
        return true;
    }
}
