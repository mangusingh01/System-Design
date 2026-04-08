package com.lld.project.Behavioral.Strategy.HolidayDiscountECommerce;

public class BulkDiscount implements DiscountStrategy {
    private final int threshold;
    private final double discountPercent;

    public BulkDiscount(int threshold, double discountPercent) {
        this.threshold = threshold;
        this.discountPercent = discountPercent;
    }

    @Override
    public double apply(double price, int quantity) {
        if (quantity >= threshold) {
            return price * quantity * (1 - discountPercent / 100);
        }
        return price * quantity;
    }

    @Override
    public String describe() {
        return discountPercent + "% off when buying " + threshold + "+";
    }
}
