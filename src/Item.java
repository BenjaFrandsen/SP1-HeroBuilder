import java.util.ArrayList;

public class Item {


    //Attributes
    private String name;
    private int weight;
    private double value;

    //Constructor
    public Item(String name, int weight, double value) {
        this.name =name;
        this.weight = weight;
        this.value = value;
    }


    //Getter
    public String getName() {
        return name;
    }

    //toString så man kan kalde en item direkte og få værdier.
    public String toString() {
        return "Item: " + name +"\nWeight: " + weight + " gram" + "\nValue: " + value +"g";
    }




}
