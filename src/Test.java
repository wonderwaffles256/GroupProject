import java.util.ArrayList;
import java.util.Arrays;

public class Test { //made to test chest room for right now but can be used for other stuff that needs to be tested
    public static void main(String[] args) {
        Weapon gun = new Weapon("gun", 100, 10, "It shoots stuff");
        Armor overalls = new Armor("overalls", 20, 10, "Ain't much, but it's honest work");
        Consumable water = new Consumable("Nestle Spring Water", 2, 5, "Capitalism's finest");
        Item rock = new Item("Charlie", 1, "A rock named Charlie");
        ArrayList<Item> items = new ArrayList<>(Arrays.asList(gun,overalls,water,rock));
        System.out.println(items.size());
        Chest c = new Chest(items);

        Chest treasure = new Chest();
        Room r = new Room(treasure,"Room1");
        System.out.println(r.getChest().getName());

    }
}
