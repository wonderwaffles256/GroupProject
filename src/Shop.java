import java.util.ArrayList;

public class Shop {
    private ArrayList<Item> inventory;

    //displays current stock of items
    public void display() {
        System.out.println("Cool Items");
    }

    //returns an item from the shop if the player has enough CORN
    public Item buy() {
        return new Item();
    }

    //gives back 5/6 of the item's CORN value
    public int sell(Item item) {
        return item.getValue();
    }
}
