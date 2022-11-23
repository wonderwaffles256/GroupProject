import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;

public class RunGame {
    //use to test runGame
    public static void main(String[] args) {
        RunGame game = new RunGame();
        game.start(1);
    }

    public void combat(Player p,Character enemy){
        System.out.println(enemy.getName() + " has appeared!");
        Scanner scnr = new Scanner(System.in);

        boolean done = false;
        while(!done) {
            //enemy says wacky funny dialogue
            boolean goodinput = false;
            while (!goodinput) {
                System.out.println("Would you like to Fight( 1 ), Flirt( 2 ), Flask ( 3 ), Flee ( 4 ), or File( 5 ).\n" +
                        "Please input 1 2 3 or 4. NOTHING ELSE and hit Enter.");
                String in = scnr.nextLine();
                switch (in) {
                    case "1" -> {
                        goodinput = true;
                        p.fight(enemy);
                    }
                    case "2" -> {
                        done = p.flirt(enemy);
                        goodinput = true;
                    }
                    case "3" -> {
                        p.flask();
                        goodinput = true;
                    }
                    case "4" -> {
                        p.flee();
                        goodinput = true;
                        done = true;
                    }
                    case "5" -> p.file(enemy);

                    default -> System.out.println("Please re-input");
                }
            }

            if(!done && enemy.getHP() > 0) {
                if(enemy instanceof Girlfriend){
                    System.out.println(((Girlfriend) enemy).dialogue());
                    ((Girlfriend) enemy).fight(p);
                }
                else{
                    enemy.fight(p);
                }
            }

            if(p.getHP() <= 0 || enemy.getHP() <= 0) {
                done = true;
            }
        }

        if(p.getHP() <= 0){
            System.out.println("You died");
            p.setHP(p.getMaxHP());
            p.setClout(1);
        }
        else if(enemy.getHP() <= 0){
            if(enemy instanceof Girlfriend){
                System.out.println("OMG I think I love you");
            }
            else{
                System.out.println("You have vanquished " + enemy.getName());
                p.setClout(p.getClout() + 0.1);
                System.out.println("Your clout increased");
            }
        }
        else {
            System.out.println("Combat resolved");
        }
    }

    public void start(int difficulty) {
        //creates each basic object in the game (such as items, weapons, etc.)
        //contains dialogue
        Weapon gun = new Weapon("gun", 100, 10, "It shoots stuff");
        Weapon club = new Weapon("wooden club", 10, 3, "Made of 100% tree");

        Armor overalls = new Armor("overalls", 20, 10, "Ain't much, but it's honest work");
        Armor noArmor = new Armor("none", 0, 0, "Nothing cheaper than a birthday suit");

        Item rock = new Item("Charlie", 1, "A rock named Charlie");
        Item heal = new Item("Coors Lite", 2, "Replenishes HP");

        //Baljbeet inputs
        ArrayList<Item> beetLoot = new ArrayList<>();
        ArrayList<String> beetBattleDialogue = new ArrayList<>();
        ArrayList<String> beetFlirtDialogue = new ArrayList<>();

        beetLoot.add(rock);
        beetBattleDialogue.add("I will BEET you");

        //this is the resulting string from the correct flirt option (placed in the constructor as its flirt requirement)
        String beetSuccess = "Thanks, I've been trying to lose weight recently. You're the first person to notice.\n*He smiles bashfully*";
        //Index 0 contains ONE string with all options for flirting
        beetFlirtDialogue.add("1 - Compliment his physique\n" + "2 - Stare into his beety eyes\n" + "3 - Playfully insult his mother");
        //Indexes 1-3 contain the results from options 1, 2, and 3
        beetFlirtDialogue.add(beetSuccess);     //correct option
        beetFlirtDialogue.add("Oh... uhhh, I can be intense too.\n*Baljbeet stares through your soul*");    //string for an incorrect option
        beetFlirtDialogue.add("Heh... she did beet me as a child");                                         //string for an incorrect option
        //

        ArrayList<Item> itemPack = new ArrayList<>();
        ArrayList<Character> companions = new ArrayList<>();

        itemPack.add(heal);

        Enemy beet = new Enemy(12, "Baljbeet", noArmor, club, 5, beetLoot, beetSuccess, 80, beetBattleDialogue, beetFlirtDialogue);

        Player player = new Player(100, "Player", overalls, gun, 10, itemPack, companions);

        //------------------------------------------------After Stuff Loaded In-----------------------------------------------------//
        System.out.println("As you walk over a hill, you can see a farm off in the distance.");
        System.out.println("At the base of the hill resides a small, round figure.");
        System.out.println("It's shadowy form turns toward you");
        combat(player,beet);

    }
}