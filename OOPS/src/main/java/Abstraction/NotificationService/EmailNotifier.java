package Abstraction.NotificationService;

public class EmailNotifier extends Notifier {
    public String getChannelName() { return "email"; }

    protected boolean send(String recipient, String message) {
        System.out.println("Sending email to " + recipient);
        return true;
    }
}

