
abstract class GameCharacter {

    String characterName;

    GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    abstract void performAttack();
}

class Warrior extends GameCharacter {

    Warrior(String characterName) {
        super(characterName);
    }

    void performAttack() {
        System.out.println(characterName + " attacks with sword");
    }
}

class Mage extends GameCharacter {

    Mage(String characterName) {
        super(characterName);
    }

    void performAttack() {
        System.out.println(characterName + " casts spell");
    }
}

class Archer extends GameCharacter {

    Archer(String characterName) {
        super(characterName);
    }

    void performAttack() {
        System.out.println(characterName + " shoots arrow");
    }
}

public class Main3 {

    static void startBattle(GameCharacter[] characters) {
        int warriors = 0;
        int mages = 0;
        int archers = 0;

        for (GameCharacter character : characters) {
            character.performAttack();

            if (character instanceof Warrior) {
                warriors++;
            } else if (character instanceof Mage) {
                mages++;
            } else if (character instanceof Archer) {
                archers++;
            }
        }

        System.out.println("Warriors=" + warriors + " Mages=" + mages + " Archers=" + archers);
    }

    public static void main(String[] args) {
        startBattle(new GameCharacter[]{
            new Warrior("Thor"),
            new Mage("Merlin"),
            new Archer("Robin"),
            new Warrior("Leo")
        });
    }
}
