package com.lld.project.Behavioral.Strategy.PaymentProcessor.AfterRefactor;

public class CryptoPayment implements PaymentStrategy {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Transferred $" + amount
                + " in BTC to wallet " + walletAddress.substring(0, 8) + "...");
    }
}
