package com.lld.project.Observer.StockPriceObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Audit trail — cares about all tickers
public class MarketAuditLog implements StockObserver {
    private final List<String> log = new ArrayList<>();

    @Override
    public void onPriceUpdate(String ticker, double oldPrice, double newPrice) {
        String entry = String.format("PRICE_UPDATE %s: %.2f -> %.2f", ticker, oldPrice, newPrice);
        log.add(entry);
        System.out.println("[AuditLog] " + entry);
    }

    public List<String> getLog() { return Collections.unmodifiableList(log); }
}
