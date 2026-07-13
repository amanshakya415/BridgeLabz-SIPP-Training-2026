package DSA.Generics;

public class SmartWarehouseManagementSystem {
	public static void main(String[] args) {
		// Demonstration of generic Storage with different WarehouseItem types
		Storage<Electronics> electronicsStorage = new Storage<>();
		electronicsStorage.add(new Electronics("E100", "Smartphone", 24));
		electronicsStorage.add(new Electronics("E101", "Laptop", 12));

		Storage<Groceries> groceriesStorage = new Storage<>();
		groceriesStorage.add(new Groceries("G200", "Milk", "2026-08-01"));
		groceriesStorage.add(new Groceries("G201", "Bread", "2026-07-20"));

		Storage<Furniture> furnitureStorage = new Storage<>();
		furnitureStorage.add(new Furniture("F300", "Chair", "Wood"));

		System.out.println("-- Electronics Storage --");
		displayAllItems(electronicsStorage.getAll());

		System.out.println("-- Groceries Storage --");
		displayAllItems(groceriesStorage.getAll());

		System.out.println("-- Furniture Storage --");
		displayAllItems(furnitureStorage.getAll());

		// Combine different types into a common list for unified display
		java.util.List<WarehouseItem> combined = new java.util.ArrayList<>();
		combined.addAll(electronicsStorage.getAll());
		combined.addAll(groceriesStorage.getAll());
		combined.addAll(furnitureStorage.getAll());

		System.out.println("-- Combined Warehouse Items --");
		displayAllItems(combined);
	}

	// Wildcard method: accepts any list of WarehouseItem or subclasses
	public static void displayAllItems(java.util.List<? extends WarehouseItem> items) {
		for (WarehouseItem item : items) {
			System.out.println(item);
		}
	}
}

// Base abstract class for all items stored in warehouse
abstract class WarehouseItem {
	private final String id;
	private final String name;

	protected WarehouseItem(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public abstract String getCategory();

	@Override
	public String toString() {
		return String.format("[%s] id=%s, name=%s", getCategory(), id, name);
	}
}

class Electronics extends WarehouseItem {
	private final int warrantyMonths;

	public Electronics(String id, String name, int warrantyMonths) {
		super(id, name);
		this.warrantyMonths = warrantyMonths;
	}

	public int getWarrantyMonths() {
		return warrantyMonths;
	}

	@Override
	public String getCategory() {
		return "Electronics";
	}

	@Override
	public String toString() {
		return String.format("%s, warranty=%d months", super.toString(), warrantyMonths);
	}
}

class Groceries extends WarehouseItem {
	private final String expirationDate;

	public Groceries(String id, String name, String expirationDate) {
		super(id, name);
		this.expirationDate = expirationDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	@Override
	public String getCategory() {
		return "Groceries";
	}

	@Override
	public String toString() {
		return String.format("%s, expires=%s", super.toString(), expirationDate);
	}
}

class Furniture extends WarehouseItem {
	private final String material;

	public Furniture(String id, String name, String material) {
		super(id, name);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	@Override
	public String getCategory() {
		return "Furniture";
	}

	@Override
	public String toString() {
		return String.format("%s, material=%s", super.toString(), material);
	}
}

// Generic storage for WarehouseItem types
class Storage<T extends WarehouseItem> {
	private final java.util.List<T> items = new java.util.ArrayList<>();

	public void add(T item) {
		items.add(item);
	}

	public boolean remove(T item) {
		return items.remove(item);
	}

	public T get(int index) {
		return items.get(index);
	}

	public java.util.List<T> getAll() {
		return new java.util.ArrayList<>(items);
	}
}
