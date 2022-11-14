import java.util.ArrayList;

public class CombatRoom extends Room{
    ArrayList<Enemy> enemies;

    //default constructor
    public CombatRoom() {
        super();
        this.enemies = new ArrayList<>();
    }

    //constructor given parameters
    public CombatRoom(String name, ArrayList<Enemy> enemies) {
        super(name);

        this.enemies = new ArrayList<>();
        this.enemies.addAll(enemies);
    }

    //returns a random enemy from the list
    public Enemy challengerApproaches() {
        return new Enemy();
    }

}
