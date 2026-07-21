interface LuggageScanner {
    default void displaySecurityGuidelines() {
        System.out.println("Luggage Policy: No prohibited liquids or sharp objects allowed in cabin baggage.");
    }
}

interface PassportVerifier {
    default void displaySecurityGuidelines() {
        System.out.println("Passport Policy: Ensure passport is valid for at least 6 months beyond travel date.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.matches("[A-Z][0-9]{7}");
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    @Override
    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }

    public void processPassengers(String[] names, String[] passports, boolean[] luggageCleared) {
        displaySecurityGuidelines();
        System.out.println();

        for (int i = 0; i < names.length; i++) {
            System.out.println("Passenger: " + names[i]);
            boolean isPassportValid = PassportVerifier.isPassportNumberValid(passports[i]);
            boolean isLuggageOk = luggageCleared[i];

            System.out.println("Passport Valid: " + isPassportValid);
            System.out.println("Luggage Cleared: " + isLuggageOk);

            if (isPassportValid && isLuggageOk) {
                System.out.println("Result: Boarding PASS");
            } else {
                System.out.println("Result: Boarding DENIED");
            }
            System.out.println();
        }
    }
}

 class MainAirportSystem {
    public static void main(String[] args) {
        String[] passengerNames = {"Alice Smith", "Bob Jones", "Charlie Brown"};
        String[] passportNumbers = {"A1234567", "12345678", "B9876543"};
        boolean[] luggageStatus = {true, true, false};

        AirportSecuritySystem system = new AirportSecuritySystem();
        system.processPassengers(passengerNames, passportNumbers, luggageStatus);
    }
}