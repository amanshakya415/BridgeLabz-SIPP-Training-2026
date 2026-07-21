interface FoodDelivery {
    default void trackOrder() {
        System.out.println("Tracking Food: Heading towards restaurant for pickup.");
    }
}

interface GroceryDelivery {
    default void trackOrder() {
        System.out.println("Tracking Grocery: Items are packed and out for delivery.");
    }

    static String generateDeliveryCode() {
        return "DEL-" + (int)(Math.random() * 9000 + 1000);
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
    @Override
    public void trackOrder() {
        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
    }

    public void processDeliveries(String[] customerNames) {
        for (String customer : customerNames) {
            System.out.println("Processing delivery for: " + customer);
            String code = GroceryDelivery.generateDeliveryCode();
            System.out.println("Assigned Delivery Code: " + code);
            trackOrder();
            System.out.println("Status: Delivery successfully finalized.");
            System.out.println();
        }
    }
}

public class MainDeliverySystem {
    public static void main(String[] args) {
        String[] customers = {"David Miller", "Emma Wilson", "Frank Thomas"};
        DeliveryExecutive executive = new DeliveryExecutive();
        executive.processDeliveries(customers);
    }
}