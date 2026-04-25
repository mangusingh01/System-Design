package com.lld.project.Decorator.CoffeeShop;

public class Main {
    public static void main(String[] args) {
        // Plain coffee
        Coffee coffee = new SimpleCoffee();
        printOrder(coffee);

        // Wrap with milk
        coffee = new MilkDecorator(coffee);
        printOrder(coffee);

        // Wrap with sugar too
        coffee = new SugarDecorator(coffee);
        printOrder(coffee);

        // Full order: milk + sugar + double vanilla
        Coffee fancyOrder = new VanillaDecorator(
                new VanillaDecorator(
                        new SugarDecorator(
                                new MilkDecorator(
                                        new SimpleCoffee()))));
        printOrder(fancyOrder);
    }

    private static void printOrder(Coffee c) {
        System.out.printf("%-45s ₹%.1f%n", c.getDescription(), c.getCost());
    }
}
