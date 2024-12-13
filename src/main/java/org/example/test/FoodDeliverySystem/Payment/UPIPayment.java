package org.example.test.FoodDeliverySystem.Payment;

public class UPIPayment implements Payment{
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean makePayment(double price) {
        System.out.println("Payment: "+price+" made using UPI:"+this.upiId);
        return true;
    }
}
