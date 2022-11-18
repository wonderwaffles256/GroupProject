import java.util.ArrayList;

public class CombatRoom extends Room{
    ArrayList<Enemy> enemies;

    /**
     * default constructor
     */
    public CombatRoom() {
        super();
        this.enemies = new ArrayList<>();
    }

    /**
     * constructor
     * @param name - name of the room
     * @param enemies - list of spawn-able enemies in the room (can change by location)
     */
    public CombatRoom(String name, ArrayList<Enemy> enemies) {
        super(name);

        this.enemies = new ArrayList<>();
        this.enemies.addAll(enemies);
    }

    /**
     * returns a random enemy from the list for combat
     * @return enemy
     */
    public Enemy challengerApproaches() {//finish later
        return new Enemy();
    }

}
