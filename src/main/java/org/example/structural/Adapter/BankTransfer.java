package org.example.structural.Adapter;

public class BankTransfer implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing "+ amount+" $ amount via bank transfer");
    }
}
