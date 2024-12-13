package org.example.test.DPQ1;

import java.util.Objects;

public class CreditCard implements Payment{
    public String cardNumber;
    public String cvc;
    public String validTill;
    public CreditCard(String cardNumber, String cvc, String validTill){
        this.cardNumber=cardNumber;
        this.cvc=cvc;
        this.validTill=validTill;
    }
    @Override
    public boolean validateDetails() {
        if(Objects.isNull(cardNumber) || Objects.isNull(cvc) || Objects.isNull(validTill))return false;
        return cardNumber.length() >= 10 && cvc.length() >= 3 && validTill.length() >= 5;
    }

    @Override
    public boolean makePayment(double price) {
       if(price < 0) throw  new InvalidPriceException("Price must be greater than 0");
       if(this.validateDetails()){
           System.out.println("Payment"+ price +" success!");
           return true;
       }
       throw new InvalidDetailsException("Card details are invalid! card number: "+cardNumber+" cvc "+cvc);
    }
}
