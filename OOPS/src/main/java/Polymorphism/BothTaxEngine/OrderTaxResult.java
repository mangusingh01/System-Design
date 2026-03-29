package Polymorphism.BothTaxEngine;

import java.util.List;

public class OrderTaxResult {
    String id;
    List<TaxResult> taxResults;
    double total;

    public OrderTaxResult(String id, List<TaxResult> taxResults, double total) {
        this.id = id;
        this.taxResults = taxResults;
        this.total = total;
    }

    public String getId() {
        return id;
    }
}
