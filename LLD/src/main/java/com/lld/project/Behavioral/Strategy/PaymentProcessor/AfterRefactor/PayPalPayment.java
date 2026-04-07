package com.lld.project.Behavioral.Strategy.PaymentProcessor.AfterRefactor;

public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Sent $" + amount + " via PayPal to " + email);
    }
}
