package Abstraction.PaymentGateway.Impl;

import Abstraction.PaymentGateway.PaymentGateway;
import Abstraction.PaymentGateway.PaymentResult;

public class StripeGateway implements PaymentGateway {
    public PaymentResult charge(double amount, String currency) {
        return new PaymentResult(true, "stripe_txn_001", "Charged");
    }
    public boolean refund(String txId) { return true; }
}