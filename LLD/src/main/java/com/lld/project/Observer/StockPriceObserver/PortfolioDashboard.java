package com.lld.project.Observer.StockPriceObserver;

// Watches everything
public class PortfolioDashboard implements StockObserver {
    @Override
    public void onPriceUpdate(String ticker, double oldPrice, double newPrice) {
        double change = ((newPrice - oldPrice) / oldPrice) * 100;
        System.out.printf("[Dashboard] %s: $%.2f → $%.2f (%+.1f%%)%n",
                ticker, oldPrice, newPrice, change);
    }
}


