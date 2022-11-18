import java.util.Scanner;

public class RunGame {
    public void load(int difficulty) {
        //creates each basic object in the game (such as items, weapons, etc.)
        //contains dialogue
        Weapon gun = new Weapon("gun", 100, 10, "It shoots stuff");
        Weapon club = new Weapon("wooden club", 10, 3, "Made of 100% tree");

        Armor overalls = new Armor("overalls", 20, 10, "Ain't much, but it's honest work");
        Armor nothing = new Armor("none", 0, 0, "Nothing cheaper than a birthday suit");

        //Enemy beet = new Enemy(12, "Baljbeet", )
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
                    }
                    case "3" -> {
                        goodinput = true;
                    }
                    case "4" -> {
                        goodinput = false;
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