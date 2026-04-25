package com.lld.project.Decorator.CoffeeShop;

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) { super(coffee); }

    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", sugar";
    }

    @Override
    public double getCost() { return wrappedCoffee.getCost() + 5.0; }
}
