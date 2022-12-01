import java.util.ArrayList;
import java.util.Random;

public class Chest {
    public static ArrayList<Item> allLoot;
    private Item loot;

    public Chest() {
        allLoot = new ArrayList<>();
    }

    public Chest(ArrayList<Item> allLoot) {
        Chest.allLoot = new ArrayList<>();
        Chest.allLoot.addAll(allLoot);
    }

    public Item randomLoot() {
        Random r = new Random();
        Item loot = allLoot.get(r.nextInt(allLoot.size()));
        return loot;
    }
    //TODO: add random loot generator

}
