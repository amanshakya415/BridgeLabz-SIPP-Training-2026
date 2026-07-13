// 2. Smart Notification System
// Scenario:
// A company sends notifications to users through different channels such as
// Email, SMS, and Push Notification.
// Create a superclass Notification with:
// ● Instance variables:
// ○ String recipientName
// ○ String message
// ● Method:
// ○ sendNotification()

// Create subclasses:
// ● EmailNotification
// ● SMSNotification
// ● PushNotification
// Each subclass should override sendNotification() and display
// channel-specific messages.
// Requirements:
// 1. Store multiple notification objects in a Notification[] array.
// 2. Take recipient names as strings.
// 3. Use dynamic method dispatch to send notifications.
// 4. Display all sent notifications.
package polymorphism.SmartNotificationSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// Create an array of notifications
		Notification[] notifications = new Notification[] {
			new EmailNotification("Alice", "Welcome to our service!"),
			new SMSNotification("Bob", "Your OTP is 123456"),
			new PushNotification("Carol", "You have a new message"),
			new EmailNotification("Dave", "Monthly newsletter")
		};

		// Use dynamic method dispatch to send notifications
		List<String> sentSummaries = new ArrayList<>();
		for (Notification n : notifications) {
			n.sendNotification();
			sentSummaries.add(n.getSummary());
		}

		// Display all sent notifications
		System.out.println("\nAll sent notifications:");
		for (String s : sentSummaries) {
			System.out.println("- " + s);
		}
	}
}
