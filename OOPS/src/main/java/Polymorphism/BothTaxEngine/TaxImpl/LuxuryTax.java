package Polymorphism.BothTaxEngine.TaxImpl;

import Polymorphism.BothTaxEngine.TaxRule;

public class LuxuryTax implements TaxRule {
    public double apply(double a) {
        return Math.round(a * 0.28 * 100) / 100.0;
    }

    public String description() {
        return "Luxury 28%";
    }
}

