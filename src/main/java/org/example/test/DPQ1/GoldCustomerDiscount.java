package org.example.test.DPQ1;

public class GoldCustomerDiscount extends PricingStrategy{
    @Override
    double priceAfterDiscount(CustomerType customerType, double price) {
        if(customerType==CustomerType.GOLD){
            if(price > 1000)return 0.8*price;
            return price;
        }
        if(this.nextPricingStrategy!=null)return this.nextPricingStrategy.priceAfterDiscount(customerType,price);
        return price;
    }
}
