package com.lld.project.Observer.StockPriceObserver;

// Only cares about AAPL — filtered via default method override
public class AppleInvestorAlert implements StockObserver {
    private static final double THRESHOLD_PERCENT = 2.0;

    @Override
    public boolean interestedIn(String ticker) {
        return "AAPL".equals(ticker); // only subscribes to AAPL events
    }

    @Override
    public void onPriceUpdate(String ticker, double oldPrice, double newPrice) {
        double changePercent = Math.abs((newPrice - oldPrice) / oldPrice * 100);
        if (changePercent >= THRESHOLD_PERCENT) {
            System.out.printf("[ALERT] AAPL moved %.1f%% — from $%.2f to $%.2f!%n",
                    changePercent, oldPrice, newPrice);
        }
    }
}
