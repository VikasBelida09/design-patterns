package org.example.Ecommerce;

public class SMSReceiptRenderer implements ReceiptRenderer{
    @Override
    public void render(String content) {
        System.out.println("Sending Receipt via/ SMS: "+content);
    }
}
