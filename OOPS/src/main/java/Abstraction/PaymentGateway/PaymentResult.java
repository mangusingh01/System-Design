package Abstraction.PaymentGateway;

public class PaymentResult {
    private boolean status;
    private String transactionId;
    private String message;

    public PaymentResult(boolean status, String id, String message){
        this.status = status;
        this.transactionId = id;
        this.message = message;
    }

    public boolean isSuccess(){
        return this.status;
    }

    public String getMessage(){
        return this.message;
    }
}
