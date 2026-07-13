package polymorphism.SmartNotificationSystem;

public class EmailNotification extends Notification {

    public EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("[Email] Sending email to " + recipientName + ": " + message);
    }
}
