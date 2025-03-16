package org.example.Ecommerce;

public abstract class OrderValidator {
    protected OrderValidator next;
    public void setNext(OrderValidator next){
        this.next=next;
    }
    public boolean validate(Order order){
        if(!doValidate(order)){
           return false;
        }
        return next==null || next.validate(order);
    }
    protected abstract boolean doValidate(Order order);
}
