/**
 * The Item class is used to store basic items the players can use within the game such as armor and
 * weapons. All items have a name and a value associated with them to identify them and show their
 * worth.
 */
public class Item {
    private String name;
    private int value;
    private String description;
    //TODO: may need to add rarity for random loot in chests

    /**
     * default constructor
     */
    public Item() {
        name = null;
        value = 0;
        description = null;
    }

    /**
     * Constructor for any items used within the game that sets any default values
     * @param name - name of said item
     * @param value - value of an item for purchase and sell price
     */
    public Item(String name, int value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }

    //getters
    public String getName() {return name;}
    public int getValue() {return value;}
    public String getDescription() {return description;}

    //setters
    public void setName(String name) {this.name = name;}
    public void setValue(int value) {this.value = value;}
    public void setDescription(String description) {this.description = description;}

}
