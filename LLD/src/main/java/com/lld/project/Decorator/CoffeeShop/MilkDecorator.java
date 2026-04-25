package com.lld.project.Decorator.CoffeeShop;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }

    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", milk";
    }

    @Override
    public double getCost() { return wrappedCoffee.getCost() + 15.0; }
}
