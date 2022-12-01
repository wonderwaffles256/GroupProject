import java.util.ArrayList;
import java.util.Random;

public class Chest {
    public static ArrayList<Item> Loot;
    private Item loot;

    public Chest() {
        Random r = new Random();
        loot = Chest.Loot.get(r.nextInt(Loot.size()));
    }

    public Chest(ArrayList<Item> allLoot) {
        Chest.Loot = new ArrayList<>();
        Chest.Loot.addAll(allLoot);
    }

    public Item getLoot() {
        return loot;
    }
}
