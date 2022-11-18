import java.util.Scanner;
import java.util.ArrayList;

public class RunGame {
    public void load(int difficulty) {
        //creates each basic object in the game (such as items, weapons, etc.)
        //contains dialogue
        Weapon gun = new Weapon("gun", 100, 10, "It shoots stuff");
        Weapon club = new Weapon("wooden club", 10, 3, "Made of 100% tree");

        Armor overalls = new Armor("overalls", 20, 10, "Ain't much, but it's honest work");
        Armor nothing = new Armor("none", 0, 0, "Nothing cheaper than a birthday suit");

        Item rock = new Item("Charlie", 1, "Just a rock named Charlie");

        ArrayList<Item> beetLoot= new ArrayList<>();

        ArrayList<String> beetDialogue = new ArrayList<>();

        beetLoot.add(rock);
        beetDialogue.add("I'm gonna BEET you!");
        //beetLoot.generateLoot();
        Enemy beet = new Enemy(12, "Baljbeet", nothing, club, 0, beetLoot, "Beet Juice", 80, beetDialogue);


        ArrayList<Item> itemPack = new ArrayList<>();
        ArrayList<Character> companions = new ArrayList<>();
        Player player = new Player(100, "Player", overalls, gun, 10, itemPack, companions);


    }

    public void generateLoot() {
        //generates random loot for enemies;
    }

    public void combat(Player p,Character enemy){
        Scanner scnr = new Scanner(System.in);

        while(p.getHP() > 0 && enemy.getHP() > 0) {
            boolean goodinput = true;
            while (goodinput) {
                System.out.println("Would you like to Fight( 1 ), Flirt( 2 ), Flask ( 3 ), or Flee ( 4 )\n" +
                                    "Please input 1 2 3 or 4. NOTHING ELSE.");
                String in = scnr.nextLine();
                switch (in) {
                    case "1" -> {
                        goodinput = true;
                        p.fight(enemy);
                    }
                    case "2" -> {
                        goodinput = true;
                        p.flirt();
                    }
                    case "3" -> {
                        goodinput = true;
                        p.flask();
                    }
                    case "4" -> {
                        goodinput = false;
                        p.flee();
                    }
                    default -> System.out.println("Bad input please try again");
                }


            }
        }

        if(p.getHP() <= 0){

        }
        else if(enemy.getHP() <= 0){

        }
    }
    //use to test runGame
    public static void main(String[] args) {

    }
}