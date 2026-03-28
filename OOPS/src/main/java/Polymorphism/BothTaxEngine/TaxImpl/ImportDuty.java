package Polymorphism.BothTaxEngine.TaxImpl;

import Polymorphism.BothTaxEngine.TaxRule;

public class ImportDuty implements TaxRule {
    public double apply(double a) { return Math.round(a * 0.10 * 100) / 100.0; }
    public String description() { return "Import 10%"; }
}
