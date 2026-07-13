package polymorphism.SmartNotificationSystem;

public class SMSNotification extends Notification {

    public SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("[SMS] Sending SMS to " + recipientName + ": " + message);
    }
}
