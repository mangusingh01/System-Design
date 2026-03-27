package Abstraction.PaymentGateway.Impl;

import Abstraction.PaymentGateway.PaymentGateway;
import Abstraction.PaymentGateway.PaymentResult;

public class MockGateway implements PaymentGateway {
    public PaymentResult charge(double amount, String currency) {
        return new PaymentResult(true, "mock_001", "Mock success");
    }
    public boolean refund(String txId) { return true; }
}
