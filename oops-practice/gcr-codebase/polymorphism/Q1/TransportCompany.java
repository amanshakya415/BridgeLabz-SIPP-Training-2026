// 1.A transport company manages a fleet: Vehicle[] containing Car, Bus, Bike
// objects. Call fuelCost(km) on each — each type calculates differently. Use
// instanceof before casting. Add a new ElectricCar without changing existing
// code (open/closed principle preview).
package polymorphism.Q1;

public class TransportCompany {
	public static void main(String[] args) {
		Vehicle[] fleet = new Vehicle[] {
			new Car("Sedan"),
			new Bus("Volvo"),
			new Bike("Yamaha"),
			new ElectricCar("Tesla Model 3")
		};

		double km = 100.0;

		for (Vehicle v : fleet) {
			System.out.print(v + " => ");

			// Use instanceof before casting as requested
			if (v instanceof Car) {
				Car c = (Car) v;
				System.out.printf("Fuel cost for %.1f km: ₹%.2f\n", km, c.fuelCost(km));
			} else if (v instanceof Bus) {
				Bus b = (Bus) v;
				System.out.printf("Fuel cost for %.1f km: ₹%.2f\n", km, b.fuelCost(km));
			} else if (v instanceof Bike) {
				Bike bi = (Bike) v;
				System.out.printf("Fuel cost for %.1f km: ₹%.2f\n", km, bi.fuelCost(km));
			} else {
				// Fallback to polymorphic call
				System.out.printf("Fuel cost for %.1f km: ₹%.2f\n", km, v.fuelCost(km));
			}
		}
	}
}
