import java.util.ArrayList;
public class Inventory {

    //Arraylist
   public static ArrayList<Item> items = new ArrayList<>();

    //tilføj items til inventory list
    public  void addItem(Item item) {
        items.add(item);
        Divider.line();
        System.out.println(item.getName() + " added to inventory");
    }


    //Fjern items fra inventory list
    public void removeItem(Item item) {
        items.remove(item);
        Divider.line();
        System.out.println(item.getName() + " has been removed from inventory");
    }

    //Printer hele inventory med enhanced for loop
    public void printInventory() {
        for (Item item: items) {
            System.out.println(item);
            Divider.line();
        }
    }

}

