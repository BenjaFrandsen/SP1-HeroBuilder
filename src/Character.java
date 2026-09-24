import java.util.Random;
public class Character {


    //Attributes for character
    private String charName;
    private char charClass;
    private int charCurrentHealth;
    private int charMaxHealth = 100;
    private int charLevel = 5;
    private boolean charIsAlive = true;
    private int damage;

    //Henter tilfældigheds element og Inventory liste fra inventory klassen
    private Inventory inventory;
    static Random random = new Random();


    //Constructor for hero character objekt
    Character(String charName, char charClass, int damage) {
        this.charName = charName;
        this.charClass = charClass;
        this.damage = damage;
        this.charCurrentHealth = charMaxHealth;
        this.inventory = new Inventory();


    }
    //Constructor for enemy character objekt
    Character(String charName) {
        this.charName = charName;
        this.charCurrentHealth = random.nextInt(50, 100);
        this.damage = random.nextInt(15,30);
    }

    //Ally(hero) character sheet
    public void  getCharSheet() {
        System.out.println("=== " + this.charName + "'s SHEET ===");
        System.out.println("Name: " + charName);
        getCharClass();
        System.out.println("Level: " + charLevel);
        System.out.println("Health: " + charCurrentHealth + "/" + charMaxHealth);
        System.out.println("Alive: " + charIsAlive);

    }
    //Enemy character sheet
    public void  getCharSheet2() {
        System.out.println("=== " + this.charName + "'s SHEET ===");
        System.out.println("Name: " + charName);
        System.out.println("Health: " + charCurrentHealth + "/" + charMaxHealth);
        System.out.println("Damage: " + this.damage);
        System.out.println("Alive: " + charIsAlive);
    }


    public Inventory getInventory() {
        return inventory;
    }

    //Combat metode:
    public void attack(Character target) {
        target.charCurrentHealth -= this.damage;
        if(target.charCurrentHealth <=0) {
            target.charCurrentHealth = 0;
        }
        System.out.println(charName +" attacks " + target.charName +" for " + damage + " damage");
    }



    //Getters
    boolean isAlive(){
        if (charCurrentHealth>0) {
            return true;
        } else {
            return false; }
    }

    public String getCharName() {
        return charName;
    }

    public int getCharCurrentHealth() {
        return charCurrentHealth;
    }

    public void getStatusCheck() {

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

    boolean isHealthCritical() {

        if (charCurrentHealth < (charMaxHealth / 4)) {
            return true;
        } else {
            return false;
        }
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




}