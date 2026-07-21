
abstract class RescueTeam {

    String teamId;
    String location;

    RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    abstract void performDuty();
}

class MedicalTeam extends RescueTeam {

    MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println("Medical at " + location);
    }
}

class FireRescueTeam extends RescueTeam {

    FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println("Fire rescue at " + location);
    }
}

class FoodSupplyTeam extends RescueTeam {

    FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println("Food supply at " + location);
    }
}

public class Main7 {

    public static void main(String[] args) {
        RescueTeam[] rescueTeams = {
            new MedicalTeam("1", "Delhi"),
            new FireRescueTeam("2", "Agra"),
            new FoodSupplyTeam("3", "Delhi"),
            new MedicalTeam("4", "Agra")
        };

        int medical = 0;
        int fire = 0;
        int food = 0;

        for (RescueTeam rescueTeam : rescueTeams) {
            rescueTeam.performDuty();

            if (rescueTeam.location.equals("Delhi")) {
                System.out.println("Found " + rescueTeam.teamId);
            }

            if (rescueTeam.teamId.startsWith("1")) {
                System.out.println("Prefix " + rescueTeam.teamId);
            }

            if (rescueTeam instanceof MedicalTeam) {
                medical++;
            } else if (rescueTeam instanceof FireRescueTeam) {
                fire++;
            } else {
                food++;
            }
        }

        System.out.println("Medical=" + medical + " Fire=" + fire + " Food=" + food);
        System.out.println(medical >= fire && medical >= food ? "Medical" : fire >= food ? "Fire" : "Food");
    }
}
