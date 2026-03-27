package Abstraction.PaymentGateway;

public interface PaymentGateway {
    PaymentResult charge(double amount, String currency);
    boolean refund(String transactionId);
}

