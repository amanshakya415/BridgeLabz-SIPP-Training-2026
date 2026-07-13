package polymorphism.Q1;

public class Car extends Vehicle {
    private static final double LITERS_PER_KM = 0.08; // ~12.5 km per liter
    private static final double PRICE_PER_LITER = 90.0;

    public Car(String name) {
        super(name);
    }

    @Override
    public double fuelCost(double km) {
        return km * LITERS_PER_KM * PRICE_PER_LITER;
    }
}
