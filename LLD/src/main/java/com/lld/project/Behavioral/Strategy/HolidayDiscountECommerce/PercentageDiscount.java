package com.lld.project.Behavioral.Strategy.HolidayDiscountECommerce;

public class PercentageDiscount implements DiscountStrategy {
    private final double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double apply(double price, int quantity) {
        return price * quantity * (1 - percent / 100);
    }

    @Override
    public String describe() {
        return percent + "% off";
    }
}

