interface HeartRateMonitor {
    default void displayHealthTips() {
        System.out.println("Cardio Tip: Aim for 150 minutes of moderate aerobic activity weekly.");
    }
}

interface TemperatureMonitor {
    default void displayHealthTips() {
        System.out.println("Fever Tip: Stay hydrated and rest if body temperature goes above 38°C (100.4°F).");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId != null && patientId.startsWith("PAT-") && patientId.length() == 7;
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
    @Override
    public void displayHealthTips() {
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    public void generateHealthReport(String[] names, String[] ids, int[] heartRates, double[] temperatures) {
        System.out.println("--- Global Health Tips ---");
        displayHealthTips();
        System.out.println("\n--- Patient Health Report ---");

        for (int i = 0; i < names.length; i++) {
            System.out.println("Patient Name: " + names[i]);
            System.out.println("Patient ID: " + ids[i]);

            if (!TemperatureMonitor.isPatientIdValid(ids[i])) {
                System.out.println("Status: INVALID PATIENT ID");
                System.out.println();
                continue;
            }

            System.out.println("Heart Rate: " + heartRates[i] + " BPM");
            System.out.println("Temperature: " + temperatures[i] + " °C");
            
            if (heartRates[i] < 60 || heartRates[i] > 100 || temperatures[i] > 37.5) {
                System.out.println("Status: REQUIRES ATTENTION");
            } else {
                System.out.println("Status: STABLE");
            }
            System.out.println();
        }
    }
}

public class MainHealthSystem {
    public static void main(String[] args) {
        String[] names = {"John Doe", "Jane Watson", "Invalid Patient"};
        String[] ids = {"PAT-101", "PAT-102", "ID-999"};
        int[] heartRates = {72, 105, 80};
        double[] temperatures = {36.6, 38.2, 36.8};

        HealthMonitoringSystem monitor = new HealthMonitoringSystem();
        monitor.generateHealthReport(names, ids, heartRates, temperatures);
    }
}