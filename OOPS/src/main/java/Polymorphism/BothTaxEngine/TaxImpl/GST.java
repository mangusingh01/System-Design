package Polymorphism.BothTaxEngine.TaxImpl;

import Polymorphism.BothTaxEngine.TaxRule;

public class GST implements TaxRule {
    public double apply(double a) {
        return Math.round(a * 0.18 * 100) / 100.0;
    }

    public String description() {
        return "GST 18%";
    }
}

