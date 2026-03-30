package Abstraction.NotificationService;

public abstract class Notifier {

    public abstract String getChannelName();

    protected abstract boolean send(String recipient, String message);

    private void validate(String recipient, String message) {
        if (recipient == null || recipient.isBlank()){
            System.out.println("Invalid recipient");
            return;
        }
        if (message == null || message.isBlank()){
            System.out.println("Invalid message");
        }
    }

    public final NotificationReceipt notify(String recipient, String msg){
        validate (recipient, msg);
        boolean success = send(recipient, msg);
        return new NotificationReceipt(getChannelName(), recipient, success);
    }
}

