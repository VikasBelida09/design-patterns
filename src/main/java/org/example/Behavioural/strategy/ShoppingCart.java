package org.example.Behavioural.strategy;

import java.util.List;

public class ShoppingCart {
    private List<String> items;
    PaymentStrategy paymentStrategy;
    public ShoppingCart(){

    }
    public void setItems(List<String>items){
        this.items=items;
    }
    public void setStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }
    public void pay(){
        int itemCost=this.items.size()*10;
        paymentStrategy.pay(itemCost);
    }

}
