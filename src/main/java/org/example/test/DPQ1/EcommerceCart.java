package org.example.test.DPQ1;

import java.util.ArrayList;
import java.util.List;

public class EcommerceCart {
    public List<Item> items;
    Payment paymentStrategy;
    PricingStrategy pricingStrategyChain;
    public EcommerceCart(PricingStrategy pricingStrategyChain){
        items=new ArrayList<>();
        this.pricingStrategyChain=pricingStrategyChain;
    }
    public void addItemToCart(Item item){
        items.add(item);
    }
    public double getTotalPrice(){
        return items.stream().reduce(0.0,(acc,item)->acc+(item.getPrice() * item.getQuantity()),Double::sum);
    }
    public boolean makePayment(Payment paymentStrategy,CustomerType type){
        this.paymentStrategy=paymentStrategy;
        return this.paymentStrategy.makePayment(pricingStrategyChain.priceAfterDiscount(type,this.getTotalPrice()));
    }

}
