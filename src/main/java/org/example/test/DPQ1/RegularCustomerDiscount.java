package org.example.test.DPQ1;

public class RegularCustomerDiscount extends PricingStrategy{
    @Override
    double priceAfterDiscount(CustomerType customerType, double price) {
        if(customerType==CustomerType.REGULAR){
            return price;
        }
        if(this.nextPricingStrategy!=null) return this.nextPricingStrategy.priceAfterDiscount(customerType,price);
        return price;
    }
}
