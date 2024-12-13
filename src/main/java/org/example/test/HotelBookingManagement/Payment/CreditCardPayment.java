package org.example.test.HotelBookingManagement.Payment;

public class CreditCardPayment implements Payment{
    private String cardNumber;
    private String cvc;
    private String validTill;

    public CreditCardPayment(String cardNumber, String cvc, String validTill) {
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.validTill = validTill;
    }
    @Override
    public boolean makePayment(double price) {
        System.out.println("Payment "+ price +" made with card ending:"+ cardNumber.substring(cardNumber.length()-5,cardNumber.length()-1));
        return true;
    }
}
