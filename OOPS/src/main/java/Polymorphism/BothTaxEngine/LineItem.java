package Polymorphism.BothTaxEngine;

import java.util.ArrayList;
import java.util.List;

public class LineItem {
    String name;
    double price;
    List<TaxRule> taxRules = new ArrayList<>();

    LineItem (String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void addTaxRule (TaxRule taxRule) {
        taxRules.add(taxRule);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<TaxRule> getTaxRules() {
        return taxRules;
    }
}
