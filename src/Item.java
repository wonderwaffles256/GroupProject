/**
 * The Item class is used to store basic items the players can use within the game such as armor and
 * weapons. All items have a name and a value associated with them to identify them and show their
 * worth.
 */
public class Item {
    private String name;
    private int value;

    //empty constructor
    public Item() {
        name = null;
        value = 0;
    }

    /**
     * Constructor for any items used within the game that sets any default values
     * @param name - name of said item
     * @param value - value of an item for purchase and sell price
     */
    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    //getters
    public String getName() {return name;}
    public int getValue() {return value;}

    //setters
    public void setName(String name) {this.name = name;}
    public void setValue(int value) {this.value = value;}

}
