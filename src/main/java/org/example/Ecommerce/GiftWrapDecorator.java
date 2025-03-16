package org.example.Ecommerce;

public class GiftWrapDecorator extends OrderDecorator{
    private final double giftWrapCost=3.0;
    public GiftWrapDecorator(IOrder order) {
        super(order);
    }
    @Override
    public double getTotalPrice(){
        return super.getTotalPrice() +giftWrapCost;
    }
    @Override
    public String getDescription(){
        return super.getDescription()+" + Gift Wrapper";
    }
}
