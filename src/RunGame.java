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

    //use to test runGame
    public static void main(String[] args) {

    }
}