package com.lld.project.Observer.StockPriceObserver;

// --- Wiring ---
public class MainFunctionalClass {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        PortfolioDashboard dashboard = new PortfolioDashboard();
        AppleInvestorAlert appleAlert = new AppleInvestorAlert();
        MarketAuditLog auditLog = new MarketAuditLog();

        market.subscribe(dashboard);
        market.subscribe(appleAlert);
        market.subscribe(auditLog);

        // Seed initial prices (no notification — oldPrice == newPrice check)
        market.updatePrice("AAPL", 170.00);
        market.updatePrice("GOOGL", 140.00);

        System.out.println("--- Price updates ---");
        market.updatePrice("AAPL", 173.50);   // +2.06% — triggers AppleAlert
        market.updatePrice("GOOGL", 141.20);  // GOOGL — AppleAlert filtered out
        market.updatePrice("AAPL", 174.00);   // smaller move — no alert

        System.out.println("\n--- Unsubscribing dashboard ---");
        market.unsubscribe(dashboard);
        market.updatePrice("AAPL", 179.00);   // dashboard no longer notified

        System.out.println("\nAudit log has " + auditLog.getLog().size() + " entries");
    }
}
