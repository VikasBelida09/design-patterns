package org.example.Ecommerce;

public class InventoryOrderValidator extends OrderValidator{
    @Override
    protected boolean doValidate(Order order) {
        if(order.getQuantity() > order.getAvailableQuantity()){
            System.out.println("InventoryValidator: Insufficient stock for order.");
            return false;
        }
        System.out.println("InventoryValidator Passed:");
        return true;
    }
}
