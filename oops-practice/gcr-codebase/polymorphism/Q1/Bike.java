package polymorphism.Q1;

public class Bike extends Vehicle {
    private static final double LITERS_PER_KM = 0.03; // ~33 km per liter
    private static final double PRICE_PER_LITER = 100.0;

    public Bike(String name) {
        super(name);
    }

    @Override
    public double fuelCost(double km) {
        return km * LITERS_PER_KM * PRICE_PER_LITER;
    }
}
