package Abstraction.NotificationService;

public class SMSNotifier extends Notifier {
    public String getChannelName() { return "sms"; }

    protected boolean send(String recipient, String message) {
        System.out.println("Sending SMS to " + recipient);
        return true;
    }
}
