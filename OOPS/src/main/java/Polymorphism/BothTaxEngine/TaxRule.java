package Polymorphism.BothTaxEngine;

public interface TaxRule {
    double apply(double amount);
    default String description() {
        return getClass().getSimpleName();
    }
}
