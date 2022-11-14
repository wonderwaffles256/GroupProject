import java.util.Random;

/**
 * Chest room is a subclass of a room that rewards the player with Corn from a chest in the room
 */
public class ChestRoom extends Room{

    /**
     * constructor
     * @param name the name of the rooms
     */
    public ChestRoom(String name){
        super(name);
    }

    /**
     * openChest jst gives the player a random amount of corn from the chest to spend later in the shop
     * @return - the amount of corn earned from a chest
     */
    public int openChest(){
        int va = 50;//val will be some random value between # and #
        System.out.println("You opened a chest and got " + va + " amount of CORN");
        return va;
    }
}
