import java.util.ArrayList;

/**
 * by obtaining in game currency players are able to buy and sell items
 */
public class Shop {
    private ArrayList<Item> inventory;

    /**
     * prints out all the item availible in the shop
     */

    //displays current stock of items needs to be done
    public void display() {

    }

    /**
     * if player meets conditions then
     * @return returns chosen item
     */

    //returns an item from the shop if the player has enough CORN
    public Item buy() {
        return new Item();
    }

    /**
     * if player chooses to sell items for currency this method is called
     * @param item item being sold to shop
     * @return 5/6th of items value
     */

    //gives back 5/6 of the item's CORN value
    public int sell(Item item) {
        return item.getValue();
    }
}
