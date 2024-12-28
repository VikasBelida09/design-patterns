package org.example.test.BookMyShow.Payment;

public class UPI implements Payment{
    private String upiId;
    public UPI(String upiId){
        this.upiId=upiId;
    }
    @Override
    public boolean processPayment(double price) {
        System.out.println("Payment: "+price+" made using UPI Id: "+upiId);
        return true;
    }
}
