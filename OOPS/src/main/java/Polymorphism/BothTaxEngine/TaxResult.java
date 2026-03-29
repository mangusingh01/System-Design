package Polymorphism.BothTaxEngine;

public class TaxResult {
    String name;
    double price;
    double tax;
    
    public TaxResult(String name, double price, double tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public double getTotal() {
        return tax + price;
    }
}
