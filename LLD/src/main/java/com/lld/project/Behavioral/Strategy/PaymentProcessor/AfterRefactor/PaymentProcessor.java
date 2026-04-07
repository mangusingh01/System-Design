package com.lld.project.Behavioral.Strategy.PaymentProcessor.AfterRefactor;

//The Context — knows nothing about HOW payment works
// It only holds a strategy reference and delegates to it

public class PaymentProcessor {
    private PaymentStrategy strategy; // Dependency Injection via DIP

    public PaymentProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    // Swap at runtime — no code change needed in this class
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        strategy.pay(amount);
    }
}
