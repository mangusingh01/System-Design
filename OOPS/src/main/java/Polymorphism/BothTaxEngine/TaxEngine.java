package Polymorphism.BothTaxEngine;

import java.util.List;
import java.util.stream.Collectors;

public class TaxEngine {

    // Overload 1: raw amount — compile-time dispatch
    public double calculate(double amount) { return amount; }

    // Overload 2: single line item — compile-time dispatch
    public TaxResult calculate(LineItem item) {
        double tax = 0;
        for (TaxRule rule : item.getTaxRules())
            tax += rule.apply(item.getPrice());
        return new TaxResult(item.getName(), item.getPrice(), tax);
    }

    // Overload 3: full order — compile-time dispatch
    public OrderTaxResult calculate(Order order) {
        List<TaxResult> results = order.getItems().stream()
                .map(this::calculate)          // resolves to overload 2
                .collect(Collectors.toList());
        double total = results.stream().mapToDouble(TaxResult::getTotal).sum();
        return new OrderTaxResult(order.getId(), results, total);
    }
}
