
abstract class Vehicle {

    String vehicleNumber;
    String ownerName;

    Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    abstract int calculateToll();
}

class Car extends Vehicle {

    Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    int calculateToll() {
        return 100;
    }
}

class Bus extends Vehicle {

    Bus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    int calculateToll() {
        return 250;
    }
}

class Truck extends Vehicle {

    Truck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    int calculateToll() {
        return 400;
    }
}

public class Main5 {

    static void calculateTotalRevenue(Vehicle[] vehicles) {
        int sum = 0;
        int max = -1;
        int cars = 0;
        int buses = 0;
        int trucks = 0;
        Vehicle highest = null;

        for (Vehicle vehicle : vehicles) {
            int toll = vehicle.calculateToll();
            sum += toll;

            if (toll > max) {
                max = toll;
                highest = vehicle;
            }

            if (vehicle instanceof Car) {
                cars++;
            } else if (vehicle instanceof Bus) {
                buses++;
            } else {
                trucks++;
            }
        }

        System.out.println(sum);
        System.out.println(highest.vehicleNumber);
        System.out.println(cars + " " + buses + " " + trucks);
    }

    static void searchVehicle(Vehicle[] vehicles, String vehicleNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.vehicleNumber.equals(vehicleNumber)) {
                System.out.println(vehicle.ownerName);
            }
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("C1", "A"),
            new Bus("B1", "B"),
            new Truck("T1", "C")
        };

        calculateTotalRevenue(vehicles);
        searchVehicle(vehicles, "B1");
    }
}
