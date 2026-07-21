interface Trackable {
    void logActivity();
    default void resetData() {
        System.out.println("Activity data has been reset.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert();
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
    public void logActivity() {
        System.out.println("Logging daily steps and heart rate.");
    }

    public void generateReport() {
        System.out.println("Generating weekly fitness report summary.");
    }

    public void sendAlert() {
        System.out.println("Alert: Daily hydration goal not met!");
    }
}

public class FitnessTracker {
    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice();
        device.logActivity();
        device.generateReport();
        device.sendAlert();
        device.resetData();
    }
}