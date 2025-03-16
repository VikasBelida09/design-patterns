package org.example.Ecommerce;

public class FraudValidator extends OrderValidator{
    @Override
    protected boolean doValidate(Order order) {
        if(order.getQuantity() > 1000){
            System.out.println("FraudValidator: Order flagged as potentially fraudulent.");
            return false;
        }
        System.out.println("FraudValidator Passed:");
        return true;
    }
}
