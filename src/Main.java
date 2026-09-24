public class Main {


    public static void main() {
        //Opretter 2 character objekter
        Character hero = new Character("Allan", 'H', 20);
        Character enemy = new Character("Green Goblin");

        //Henter character sheets
        hero.getCharSheet();
        enemy.getCharSheet2();

        hero.getStatusCheck();

        //Opretter item objekter
        Item item1 = new Item("Bow", 25, 150);
        Item item2 = new Item("Arrows", 2, 50);
        Item item3 = new Item("Health Potion", 5, 50);

        // Tilføjer items til
        hero.getInventory().addItem(item1);
        hero.getInventory().addItem(item2);
        hero.getInventory().addItem(item3);
        hero.getInventory().printInventory();
        hero.getInventory().removeItem(item3);


        //Combat loop
        System.out.println("-----COMBAT-----");

        while (hero.isAlive() && enemy.isAlive()) {

            //i dette loop angriber Hero altid først(hvis enemy = isAlive), man kan lave et IF/ELSE-statement, hvor begge objekter har en speed stat.

            hero.attack(enemy);
            if (!enemy.isAlive()) {
                break;
            }
            enemy.attack(hero);

            System.out.println(hero.getCharName() + ": new HP - " + hero.getCharCurrentHealth());
            System.out.println(enemy.getCharName() + ": new HP - " + enemy.getCharCurrentHealth());


        }

        System.out.println("-----Result-----");
        if (hero.isAlive()) {
            System.out.println(hero.getCharName() + " Wins!");
        } else {
            System.out.println(enemy.getCharName() + " Wins!");
        }


    }

    // Ting man kan udvikle videre på:
    // Items bliver brugt i combat og deres stats betyder noget.
    // Lave user input med scanner til combat, så kan man bruge utility items.
    // Kan kun angribe hvis arrowAmount > 0 og bruge decrement amount--
    // Lave nedarvning i klasserne især i Item klassen, så man kan have flere typer
    // Lave shop

}
