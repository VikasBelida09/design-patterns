package org.example.test.DPQ1;

public interface Payment {
    boolean validateDetails();
    boolean makePayment(double price);
}
