package com.lld.project.Behavioral.Strategy.PaymentProcessor;

import com.lld.project.Behavioral.Strategy.PaymentProcessor.AfterRefactor.CreditCardPayment;
import com.lld.project.Behavioral.Strategy.PaymentProcessor.AfterRefactor.PayPalPayment;
import com.lld.project.Behavioral.Strategy.PaymentProcessor.AfterRefactor.CryptoPayment;

import com.lld.project.Behavioral.Strategy.PaymentProcessor.AfterRefactor.PaymentProcessor;

public class UseMeClass {

    PaymentProcessor processor = new PaymentProcessor(
            new CreditCardPayment("4111111111111234")
    );

    processor.processPayment(99.99);

    processor.setStrategy(new PayPalPayment("user@example.com"));
    processor.processPayment(49.99);

    processor.setStrategy(new CryptoPayment("1A2B3C4D5E6F7G8H9I"));
    processor.processPayment(200.00);
}
