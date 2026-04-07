package com.lld.project.Behavioral.Strategy.PaymentProcessor;

public class AntiPatternSolution {
    private String paymentType;

    public AntiPatternSolution(String paymentType) {
        this.paymentType = paymentType;
    }

    // OCP violation: every new payment method requires editing this class
    // Cohesion problem: one class knows about Stripe, PayPal, AND Crypto
    public void processPayment(double amount) {
        if (paymentType.equals("CREDIT_CARD")) {
            System.out.println("Processing $" + amount + " via Stripe...");
            // Stripe-specific logic, SDK calls, error handling...
        } else if (paymentType.equals("PAYPAL")) {
            System.out.println("Processing $" + amount + " via PayPal...");
            // PayPal-specific logic...
        } else if (paymentType.equals("CRYPTO")) {
            System.out.println("Processing $" + amount + " via Crypto...");
            // Crypto-specific logic...
        }
        // New method? Edit this file. Again. And again.
    }
}
