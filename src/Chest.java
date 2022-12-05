import java.util.ArrayList;
import java.util.Random;

/**
 * Chest holds an arraylist of loot and randomly gives it to the user
 */
public class Chest {
    public static ArrayList<Item> Loot;
    private Item loot;

    /**
     * constructor that creates a chest with some random loot from the arraylist of loot
     */
    public Chest() {
        Random r = new Random();
        loot = Chest.Loot.get(r.nextInt(Loot.size()));
    }

    /**
     * constructor to put all the loot into the chest class
     * @param allLoot - an arraylist that contains all the possible loot that can appear in the chest
     */
    public Chest(ArrayList<Item> allLoot) {
        Chest.Loot = new ArrayList<>();
        Chest.Loot.addAll(allLoot);
    }

    /**
     * retrieves a random piece of loot from the chest
     * @return some random item of loot
     */
    public Item getLoot() {
        return loot;
    }
}
