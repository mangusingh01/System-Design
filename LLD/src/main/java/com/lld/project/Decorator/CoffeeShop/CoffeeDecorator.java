package com.lld.project.Decorator.CoffeeShop;

public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee wrappedCoffee;   // the object being decorated

    public CoffeeDecorator(Coffee coffee) {
        this.wrappedCoffee = coffee;
    }

    // Default: pure delegation. Subclasses override to add behaviour.
    @Override
    public String getDescription() { return wrappedCoffee.getDescription(); }

    @Override
    public double getCost() { return wrappedCoffee.getCost(); }
}
