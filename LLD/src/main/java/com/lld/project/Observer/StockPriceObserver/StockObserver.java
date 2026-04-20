package com.lld.project.Observer.StockPriceObserver;

public interface StockObserver {
    void onPriceUpdate(String ticker, double oldPrice, double newPrice);

    // Optional: observer declares which tickers it cares about.
    // Default = all tickers (backward-compatible interface extension)
    default boolean interestedIn(String ticker) {
        return true;
    }
}
