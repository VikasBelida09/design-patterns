package org.example.test.DPQ1;

public class PremiumCustomerDiscount extends PricingStrategy{
    @Override
    double priceAfterDiscount(CustomerType customerType, double price) {
        if(customerType==CustomerType.PREMIUM){
            if(price > 500) return 0.9*price;
            return price;
        }
        if(this.nextPricingStrategy!=null)return this.nextPricingStrategy.priceAfterDiscount(customerType,price);
        return price;
    }
}
