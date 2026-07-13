package polymorphism.Q1;

public abstract class Vehicle {
    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double fuelCost(double km);

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + name + ")";
    }
}
