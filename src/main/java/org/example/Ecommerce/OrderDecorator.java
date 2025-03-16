package org.example.Ecommerce;

public abstract class OrderDecorator implements IOrder{
    protected  IOrder wrappedOrder;

    public OrderDecorator(IOrder order){
        this.wrappedOrder=order;
    }
    @Override
    public double getTotalPrice() {
        return wrappedOrder.getTotalPrice();
    }

    @Override
    public String getDescription() {
        return wrappedOrder.getDescription();
    }

    @Override
    public int getQuantity() {
        return wrappedOrder.getQuantity();
    }

    @Override
    public int getAvailableQuantity() {
        return wrappedOrder.getAvailableQuantity();
    }
}
