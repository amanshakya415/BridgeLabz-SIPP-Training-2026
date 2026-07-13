// 1.Build a fitness tracker: interfaces Trackable (logActivity()), Reportable
// (generateReport()), Notifiable (sendAlert()). Class FitnessDevice
// implements all three. Add a default method resetData() to Trackable.
// Demonstrate multiple interface implementation Java cannot do with
// classes.
package Interfaces;

interface Trackable {
    void logActivity(String activity, int durationMinutes);

    default void resetData() {
        System.out.println("Fitness data has been reset.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert(String message);
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
    private String lastActivity;
    private int lastDuration;
    private int totalMinutes;
    private int sessionCount;

    @Override
    public void logActivity(String activity, int durationMinutes) {
        lastActivity = activity;
        lastDuration = durationMinutes;
        totalMinutes += durationMinutes;
        sessionCount++;
        System.out.printf("Logged activity: %s for %d minutes.%n", activity, durationMinutes);
    }

    @Override
    public void generateReport() {
        System.out.println("----- Fitness Report -----");
        System.out.printf("Sessions logged: %d%n", sessionCount);
        System.out.printf("Last activity: %s (%d minutes)%n", lastActivity, lastDuration);
        System.out.printf("Total workout time: %d minutes%n", totalMinutes);
        System.out.println("--------------------------");
    }

    @Override
    public void sendAlert(String message) {
        System.out.printf("ALERT: %s%n", message);
    }
}

public class FitnessTracker {
    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice();

        device.logActivity("Running", 30);
        device.logActivity("Cycling", 45);
        device.generateReport();
        device.sendAlert("Time to hydrate!");
        device.resetData();
    }
}
