package com.lld.project.Behavioral.Strategy.HolidayDiscountECommerce;

public class ShoppingCart {
    private DiscountStrategy discountStrategy;

    public ShoppingCart(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public double checkout(double unitPrice, int quantity) {
        double total = discountStrategy.apply(unitPrice, quantity);
        System.out.printf("Strategy: %-35s | Total: $%.2f%n",
                discountStrategy.describe(), total);
        return total;
    }
}
