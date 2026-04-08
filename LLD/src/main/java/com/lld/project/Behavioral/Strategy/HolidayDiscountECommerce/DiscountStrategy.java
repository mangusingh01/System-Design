package com.lld.project.Behavioral.Strategy.HolidayDiscountECommerce;

public interface DiscountStrategy {
    double apply(double price, int quantity);
    String describe();
}

