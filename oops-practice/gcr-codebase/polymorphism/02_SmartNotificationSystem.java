
class Notification {

    String recipientName;
    String message;

    Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    void sendNotification() {
    }
}

class EmailNotification extends Notification {

    EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    void sendNotification() {
        System.out.println("Email to " + recipientName + ": " + message);
    }
}

class SMSNotification extends Notification {

    SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    void sendNotification() {
        System.out.println("SMS to " + recipientName + ": " + message);
    }
}

class PushNotification extends Notification {

    PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    void sendNotification() {
        System.out.println("Push to " + recipientName + ": " + message);
    }
}

public class Main2 {

    public static void main(String[] args) {
        Notification[] notifications = {
            new EmailNotification("A", "Hi"),
            new SMSNotification("B", "Hello"),
            new PushNotification("C", "Welcome")
        };

        for (Notification notification : notifications) {
            notification.sendNotification();
        }
    }
}
