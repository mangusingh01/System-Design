package com.lld.project.Decorator.CoffeeShop;

public class VanillaDecorator extends CoffeeDecorator {
    public VanillaDecorator(Coffee coffee) { super(coffee); }

    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", vanilla";
    }

    @Override
    public double getCost() { return wrappedCoffee.getCost() + 25.0; }
}
