package org.example.Ecommerce;

public class ExpressShippingDecorator extends OrderDecorator{
    private final double expressShippingCost=10.0;
    public ExpressShippingDecorator(IOrder order) {
        super(order);
    }
    @Override
    public double getTotalPrice(){
        return super.getTotalPrice() + expressShippingCost;
    }
    @Override
    public String getDescription(){
        return super.getDescription() +" + Express Shipping cost";
    }
}
