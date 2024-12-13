package org.example.test.DPQ1;

public abstract class PricingStrategy {
    protected PricingStrategy nextPricingStrategy;
    public void setNextPricingStrategy(PricingStrategy pricingStrategy){
        this.nextPricingStrategy=pricingStrategy;
    }
    abstract double priceAfterDiscount(CustomerType customerType, double price);
}
