// 1. An address book app stores contacts (name, phone, email). Use
// ArrayList for ordered storage, HashMap for fast name lookup, HashSet to
// prevent duplicate phone numbers. Implement: add, search, delete, display
// sorted by name using Collections.sort().
package DSA.CollectionFrameworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddressBookApp {

	static class Contact implements Comparable<Contact> {
		private final String name;
		private final String phone;
		private final String email;

		public Contact(String name, String phone, String email) {
			this.name = name;
			this.phone = phone;
			this.email = email;
		}

		public String getName() { return name; }
		public String getPhone() { return phone; }
		public String getEmail() { return email; }

		@Override
		public String toString() {
			return String.format("%s - %s - %s", name, phone, email);
		}

		@Override
		public int compareTo(Contact other) {
			return this.name.compareToIgnoreCase(other.name);
		}
	}

	private final List<Contact> contacts = new ArrayList<>();
	private final Map<String, List<Contact>> nameIndex = new HashMap<>();
	private final Map<String, Contact> phoneIndex = new HashMap<>();
	private final Set<String> phoneSet = new HashSet<>();

	// Add contact: returns true if added, false if duplicate phone
	public boolean addContact(String name, String phone, String email) {
		if (phone == null || phone.isEmpty()) return false;
		if (phoneSet.contains(phone)) return false; // prevent duplicate phone numbers

		Contact c = new Contact(name, phone, email);
		contacts.add(c);
		phoneSet.add(phone);
		phoneIndex.put(phone, c);
		nameIndex.computeIfAbsent(name, k -> new ArrayList<>()).add(c);
		return true;
	}

	// Search by name (returns list, may be empty)
	public List<Contact> searchByName(String name) {
		return nameIndex.getOrDefault(name, Collections.emptyList());
	}

	// Search by phone
	public Contact searchByPhone(String phone) {
		return phoneIndex.get(phone);
	}

	// Delete by phone
	public boolean deleteByPhone(String phone) {
		Contact c = phoneIndex.remove(phone);
		if (c == null) return false;
		contacts.remove(c);
		phoneSet.remove(phone);
		List<Contact> list = nameIndex.get(c.getName());
		if (list != null) {
			list.remove(c);
			if (list.isEmpty()) nameIndex.remove(c.getName());
		}
		return true;
	}

	// Delete all contacts by name
	public boolean deleteByName(String name) {
		List<Contact> list = nameIndex.remove(name);
		if (list == null || list.isEmpty()) return false;
		for (Contact c : list) {
			contacts.remove(c);
			phoneIndex.remove(c.getPhone());
			phoneSet.remove(c.getPhone());
		}
		return true;
	}

	// Display all contacts sorted by name
	public void displaySortedByName() {
		List<Contact> copy = new ArrayList<>(contacts);
		Collections.sort(copy);
		for (Contact c : copy) System.out.println(c);
	}

	// Demo main
	public static void main(String[] args) {
		AddressBookApp app = new AddressBookApp();

		System.out.println("Adding contacts:");
		System.out.println(app.addContact("Alice", "111-222-3333", "alice@example.com") ? "Added Alice" : "Failed Alice");
		System.out.println(app.addContact("Bob", "222-333-4444", "bob@example.com") ? "Added Bob" : "Failed Bob");
		System.out.println(app.addContact("Charlie", "333-444-5555", "charlie@example.com") ? "Added Charlie" : "Failed Charlie");

		// Attempt duplicate phone
		System.out.println(app.addContact("Alicia", "111-222-3333", "alicia@example.com") ? "Added Alicia" : "Duplicate phone - rejected");

		System.out.println("\nSearch by name 'Bob':");
		for (Contact c : app.searchByName("Bob")) System.out.println(c);

		System.out.println("\nSearch by phone '333-444-5555':");
		System.out.println(app.searchByPhone("333-444-5555"));

		System.out.println("\nDisplay all (sorted by name):");
		app.displaySortedByName();

		System.out.println("\nDelete by name 'Alice': " + (app.deleteByName("Alice") ? "deleted" : "not found"));
		System.out.println("\nDisplay after deletion:");
		app.displaySortedByName();
	}
}
