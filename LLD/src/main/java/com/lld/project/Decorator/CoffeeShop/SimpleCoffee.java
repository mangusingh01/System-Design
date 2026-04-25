package com.lld.project.Decorator.CoffeeShop;

public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() { return "Simple coffee"; }

    @Override
    public double getCost() { return 50.0; }
}
