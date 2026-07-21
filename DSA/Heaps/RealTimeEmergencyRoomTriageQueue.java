import java.util.PriorityQueue;

public class RealTimeEmergencyRoomTriageQueue {
    private PriorityQueue<Patient> triageQueue;

    public RealTimeEmergencyRoomTriageQueue() {
        // Initialize a max-heap based on severity score
        triageQueue = new PriorityQueue<>((a, b) -> b.getSeverity() - a.getSeverity());
    }

    // Add a new patient to the queue
    public void addPatient(Patient p) {
        triageQueue.offer(p); // O(log n)
    }

    // Retrieve and remove the most severe patient
    public Patient treatNext() {
        return triageQueue.poll(); // O(log n)
    }

    // Peek at the most severe patient without removing
    public Patient peekMostSevere() {
        return triageQueue.peek(); // O(1)
    }
}

class Patient {
    private final String name;
    private final int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', severity=" + severity + '}';
    }
}
