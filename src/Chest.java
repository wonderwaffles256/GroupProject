import java.util.ArrayList;

public class Chest {
    private ArrayList<Item> allLoot;

    public Chest() {
        allLoot = new ArrayList<>();
    }

    public Chest(ArrayList<Item> allLoot) {
        this.allLoot = new ArrayList<>();
        this.allLoot.addAll(allLoot);
    }

    //TODO: add random loot generator

}
