package Polymorphism.BothTaxEngine;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private List<LineItem> items = new ArrayList<>();

    public Order(String orderId) {
        this.id = orderId;
    }

    public String getId() {
        return id;
    }

    public List<LineItem> getItems() {
        return items;
    }
}
