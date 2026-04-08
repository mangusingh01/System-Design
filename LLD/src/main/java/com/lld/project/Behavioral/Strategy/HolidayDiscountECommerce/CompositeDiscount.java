package com.lld.project.Behavioral.Strategy.HolidayDiscountECommerce;

import java.util.ArrayList;
import java.util.List;

public class CompositeDiscount implements DiscountStrategy {
    private final List<DiscountStrategy> strategies = new ArrayList<>();

    public CompositeDiscount add(DiscountStrategy s) {
        strategies.add(s);
        return this; // fluent builder
    }

    @Override
    public double apply(double price, int quantity) {
        double total = price * quantity;
        for (DiscountStrategy s : strategies) {
            // Apply each strategy to the running total
            double discounted = s.apply(total / quantity, (int)(total / price));
            total = discounted;
        }
        return total;
    }

    @Override
    public String describe() {
        return strategies.stream()
                .map(DiscountStrategy::describe)
                .reduce((a, b) -> a + " + " + b)
                .orElse("None");
    }
}

