
abstract class Subscription {

    String subscriberName;
    String subscriptionId;

    Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    abstract int calculateMonthlyCharge();
}

class BasicPlan extends Subscription {

    BasicPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    int calculateMonthlyCharge() {
        return 199;
    }
}

class PremiumPlan extends Subscription {

    PremiumPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    int calculateMonthlyCharge() {
        return 499;
    }
}

class FamilyPlan extends Subscription {

    FamilyPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    int calculateMonthlyCharge() {
        return 799;
    }
}

public class Main6 {

    public static void main(String[] args) {
        Subscription[] subscriptions = {
            new BasicPlan("Alice", "1"),
            new PremiumPlan("Bob", "2"),
            new FamilyPlan("Alex", "3")
        };

        int revenue = 0;
        int max = -1;
        Subscription best = null;

        for (Subscription subscription : subscriptions) {
            int charge = subscription.calculateMonthlyCharge();
            revenue += charge;

            if (charge > max) {
                max = charge;
                best = subscription;
            }

            if (subscription.subscriberName.startsWith("A")) {
                System.out.println(subscription.subscriberName);
            }

            if (subscription.subscriptionId.equals("2")) {
                System.out.println("Found " + subscription.subscriberName);
            }
        }

        System.out.println(revenue);
        System.out.println(best.subscriberName);
    }
}
