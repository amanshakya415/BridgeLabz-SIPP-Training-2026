package ExceptionHandling;

public class HospitalBillingSystem {
	// Simple in-memory patient list for demo
	private static final String[] patients = {"Alice", "Bob", "Charlie"};

	// Custom exception for payment failures
	public static class InsufficientFundsException extends Exception {
		public InsufficientFundsException(String message) {
			super(message);
		}
	}

	public static double parseAmount(String s) throws NumberFormatException {
		return Double.parseDouble(s);
	}

	public static int parseQuantity(String s) throws NumberFormatException {
		return Integer.parseInt(s);
	}

	public static double calculateTotal(double unitPrice, int quantity) {
		return unitPrice * quantity;
	}

	public static double costPerItem(double total, int items) {
		if (items == 0) {
			throw new ArithmeticException("Bill has zero items");
		}
		return total / items;
	}

	public static void processPayment(double amountDue, double paid) throws InsufficientFundsException {
		if (paid < amountDue) {
			throw new InsufficientFundsException(String.format("Payment failed: paid %.2f but amount due is %.2f", paid, amountDue));
		}
		System.out.println(String.format("Payment accepted: paid %.2f, change %.2f", paid, paid - amountDue));
	}

	public static String getPatient(int index) {
		return patients[index]; // may throw ArrayIndexOutOfBoundsException
	}

	// Demo main that exercises the required exception handling paths
	public static void main(String[] args) {
		// Scenario 1: division-by-zero (zero items)
		try {
			String unitPriceStr = "100.0";
			String quantityStr = "0"; // zero items

			double price = parseAmount(unitPriceStr);
			int quantity = parseQuantity(quantityStr);
			double total = calculateTotal(price, quantity);
			try {
				double perItem = costPerItem(total, quantity);
				System.out.println("Per-item cost: " + perItem);
			} catch (ArithmeticException e) {
				System.out.println("Error computing per-item cost: " + e.getMessage());
			}

			try {
				processPayment(total, 50.0);
			} catch (InsufficientFundsException e) {
				System.out.println(e.getMessage());
			}

		} catch (NumberFormatException e) {
			System.out.println("Invalid numeric input: " + e.getMessage());
		}

		// Scenario 2: array out-of-bounds (invalid patient index)
		try {
			System.out.println("Patient lookup: " + getPatient(10));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid patient index: " + e.getMessage());
		}

		// Scenario 3: number format exception (bad input)
		try {
			System.out.println("Parsing bad amount: " + parseAmount("not-a-number"));
		} catch (NumberFormatException e) {
			System.out.println("Invalid numeric input: " + e.getMessage());
		}
	}
}
