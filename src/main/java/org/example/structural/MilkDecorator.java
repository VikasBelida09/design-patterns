package org.example.structural;

public class MilkDecorator extends CoffeDecorator{
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return coffee.getDescription()+", Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost()+1.5;
    }
}
