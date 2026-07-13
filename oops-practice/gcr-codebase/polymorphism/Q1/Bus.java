package polymorphism.Q1;

public class Bus extends Vehicle {
    private static final double LITERS_PER_KM = 0.5;
    private static final double PRICE_PER_LITER = 80.0;

    public Bus(String name) {
        super(name);
    }

    @Override
    public double fuelCost(double km) {
        return km * LITERS_PER_KM * PRICE_PER_LITER;
    }
}
