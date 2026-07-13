package polymorphism.SmartNotificationSystem;

public class PushNotification extends Notification {

    public PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("[Push] Sending push notification to " + recipientName + ": " + message);
    }
}
