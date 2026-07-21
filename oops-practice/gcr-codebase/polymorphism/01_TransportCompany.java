
abstract class Vehicle {

    String number;

    Vehicle(String number) {
        this.number = number;
    }

    abstract double fuelCost(int km);
}

class Car extends Vehicle {

    Car(String number) {
        super(number);
    }

    double fuelCost(int km) {
        return km * 6.5;
    }
}

class Bus extends Vehicle {

    Bus(String number) {
        super(number);
    }

    double fuelCost(int km) {
        return km * 12;
    }
}

class Bike extends Vehicle {

    Bike(String number) {
        super(number);
    }

    double fuelCost(int km) {
        return km * 2;
    }
}

class ElectricCar extends Vehicle {

    ElectricCar(String number) {
        super(number);
    }

    double fuelCost(int km) {
        return km * 1.2;
    }
}

public class Main1 {

    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("C1"),
            new Bus("B1"),
            new Bike("BK1"),
            new ElectricCar("E1")
        };

        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                System.out.println("Car");
            } else if (vehicle instanceof Bus) {
                System.out.println("Bus");
            } else if (vehicle instanceof Bike) {
                System.out.println("Bike");
            } else if (vehicle instanceof ElectricCar) {
                System.out.println("ElectricCar");
            }

            System.out.println(vehicle.fuelCost(100));
        }
    }
}
