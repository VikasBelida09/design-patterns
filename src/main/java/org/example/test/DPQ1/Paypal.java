package org.example.test.DPQ1;

import java.util.Objects;

public class Paypal implements Payment{
    private String email;
    public Paypal(String email){
        this.email=email;
    }
    @Override
    public boolean validateDetails() {
        return !Objects.isNull(email) && !this.email.isBlank();
    }

    @Override
    public boolean makePayment(double price) {
        if(price <= 0) throw new InvalidPriceException(price+" is invalid and must be greater than 0");
        if(this.validateDetails()){
            System.out.println("Payment "+price+" success!");
            return true;
        }
        throw new InvalidDetailsException("we couldn't find the account: "+email);
    }
}
