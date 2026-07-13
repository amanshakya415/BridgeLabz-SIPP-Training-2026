package polymorphism.Q1;

public class ElectricCar extends Car {
    private static final double KWH_PER_KM = 0.15; // kWh per km
    private static final double PRICE_PER_KWH = 10.0;

    public ElectricCar(String name) {
        super(name);
    }

    @Override
    public double fuelCost(double km) {
        return km * KWH_PER_KM * PRICE_PER_KWH;
    }
}
