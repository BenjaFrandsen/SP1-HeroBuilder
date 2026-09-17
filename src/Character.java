import java.sql.SQLOutput;

public class Character {

    String charName = "Brann Bronzebeard";
    String charRace = "Dwarf";
    char charClass = 'H';
    int charCurrentHealth = 100;
    int charMaxHealth = 180;
    int charLevel = 5;
    int experiencePoints = 2250;
    double charGold = 125.50;
    boolean charIsAlive = true;
    boolean canLevelUp;

    String[] charInventory = {"Bow", "Arrows", "Potions"};


    void getDivider() {
        System.out.println("---------------------------");
    }

    void getInventory() {
        System.out.println("Inventory (" + charInventory.length + " Items)");


        for (int i = 0; i < charInventory.length; i++) {
            System.out.println("-" + charInventory[i]);
        }

    }

    void getCharSheet() {
        System.out.println("=== CHARACTER SHEET ===");
        System.out.println("Name: " + charName);
        getCharClass();
        System.out.println("Race: " + charRace);
        System.out.println("Level: " + charLevel);
        System.out.println("Health: " + charCurrentHealth + "/" + charMaxHealth);
        System.out.println("XP: " + experiencePoints);
        System.out.println("Gold: " + charGold);
        System.out.println("Alive: " + charIsAlive);
    }

    void checkLevelUp() { //Kan splittes så man laver et level check og en anden når man skal kalde metoden i andre metoder.
        int expForNextLvl = (500 * charLevel) - experiencePoints;
        if (experiencePoints >= 500 * charLevel) {
            System.out.println("Ready to Level Up!");
            canLevelUp = true;
        } else {
            System.out.println("Character still need: " + expForNextLvl + " exp to level up! ");
        }
    }

    void takeDamage(int amount) {
        charCurrentHealth -= amount;
        System.out.println("Damage taken: " + amount);
        System.out.println("Current HP: "+ charCurrentHealth);

    }

    void heal(int amount) { // Tager ikke højde for hvis man healer over max hp.. løsning skal findes
        if (charCurrentHealth + amount <= charMaxHealth) {
            charCurrentHealth += amount;
            System.out.println("Healed: " + amount + "HP");
        } else {
            System.out.println("Already full health");
        }
        System.out.println("Current HP: " + charCurrentHealth);
    }

    void checkGold() {
        System.out.println("Chararacter gold: " + charGold);
    }

    void addGold(double amount) {
        charGold += amount;
        System.out.println("Gold added: " + amount);
        checkGold();
    }

    boolean removeGold(double amount) {

        if (charGold >= amount) {
            charGold -= amount;
            System.out.println("Gold spent: " + amount);
            checkGold();
            return true;

        } else {
            return false;
        }

    }

    void addexperience(int amount) {
        experiencePoints += amount;
        System.out.println("XP gained: " + amount);
        checkLevelUp();

    }

    void levelUp(){
        //checkLevelUp();
        if(canLevelUp) {
            charLevel++;
            experiencePoints = 0;
            charMaxHealth *= 1.1;
            System.out.println("New level: " + charLevel );
            System.out.println("New XP: " + experiencePoints);
            System.out.println("New max HP: " + charMaxHealth);
        } else {
            System.out.println("Cant level up yet");
        }
    }

    boolean isHealthCritical() {

        if (charCurrentHealth < (charMaxHealth / 4)) {
            return true;
        } else {
            return false;
        }
    }

    boolean isAlive(){
        if (charCurrentHealth>0) {
            return true;
        } else {
            return false; }
    }

    void getStatusCheck() {

        if (isHealthCritical()) {
            System.out.println("WARNING: Health Critical!");
        }


        if (isAlive()) {
            System.out.println("Character is alive");
        } else {
            System.out.println("Character is dead");
        }
        System.out.println("Health Percentage: " + getHealthPercentage() +"%");
    }

    void getCharClass() {
        switch (charClass) {
            case 'H':
                System.out.println("Class: H (Hunter)");
                break;
            case 'W':
                System.out.println("Class: W (Warrior)");
                break;
            case 'M':
                System.out.println("Class: M (Mage)");
                break;
            case 'D':
                System.out.println("Class: D (Druid)");
                break;
            case 'P':
                System.out.println("Class P: (Paladin)");
                break;

            default:
                System.out.println("Invalid Class");
        }
    }

    double getHealthPercentage() {
        double charHealthPercentage = ((double)charCurrentHealth / charMaxHealth) * 100;
        return charHealthPercentage;
    }


    void main() {
        getCharSheet();
        getDivider();
        getInventory();
        getDivider();
        checkLevelUp();
        getDivider();
        takeDamage(60);
        getDivider();
        heal(60);
        getDivider();
        addGold(20);
        getDivider();
        removeGold(40);
        getDivider();
        addexperience(250);
        getDivider();
        levelUp();
        isHealthCritical();
        getDivider();
        getStatusCheck();
        getCharSheet();

    }


}