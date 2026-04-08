package com.lld.project.Behavioral.Strategy.HolidayDiscountECommerce;

public class NoDiscount implements DiscountStrategy {
    @Override public double apply(double price, int quantity) { return price * quantity; }
    @Override public String describe() { return "No discount"; }
}
