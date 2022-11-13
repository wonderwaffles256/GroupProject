import java.util.ArrayList;
import java.util.Random;

public class CombatRoom extends Location{
    ArrayList<Enemy> enemies;

    //default constructor
    public CombatRoom() {
        super();
        this.enemies = new ArrayList<>();
    }

    //constructor given parameters
    public CombatRoom(String name, int difficulty, int currentLoc, int progress, ArrayList<Enemy> enemies) {
        super(name, difficulty, currentLoc, progress);

        this.enemies = new ArrayList<>();
        this.enemies.addAll(enemies);
    }

    //returns a random enemy from the list
    public Enemy challengerApproaches() {
        return new Enemy();
    }

}
