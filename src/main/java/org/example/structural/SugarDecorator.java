package org.example.structural;

public class SugarDecorator extends CoffeDecorator{
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return coffee.getDescription()+", Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost()+1;
    }
}
