package Abstraction.PaymentGateway;

public class CheckoutService {
    private final PaymentGateway gateway; // interface type, not concrete

    public CheckoutService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public PaymentResult checkout(double total, String currency) {
        PaymentResult result = gateway.charge(total, currency);
        if (!result.isSuccess())
            throw new RuntimeException("Payment failed: " + result.getMessage());
        return result;
    }
}