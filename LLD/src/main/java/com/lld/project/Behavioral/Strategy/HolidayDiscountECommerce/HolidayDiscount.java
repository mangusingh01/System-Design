package com.lld.project.Behavioral.Strategy.HolidayDiscountECommerce;

public class HolidayDiscount {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new NoDiscount());

        System.out.println("=== Guest customer ===");
        cart.setStrategy(new NoDiscount());
        cart.checkout(100.0, 3); // $300

        System.out.println("\n=== Loyalty member (10% off) ===");
        cart.setStrategy(new PercentageDiscount(10));
        cart.checkout(100.0, 3); // $270

        System.out.println("\n=== Wholesale buyer (20% off for 5+) ===");
        cart.setStrategy(new BulkDiscount(5, 20));
        cart.checkout(100.0, 2); // $200 (below threshold)
        cart.checkout(100.0, 7); // $560 (discount applied)

        System.out.println("\n=== VIP (10% membership + 5% loyalty) ===");
        cart.setStrategy(new CompositeDiscount()
                .add(new PercentageDiscount(10))
                .add(new PercentageDiscount(5)));
        cart.checkout(100.0, 3); // ~$256.50
    }
}