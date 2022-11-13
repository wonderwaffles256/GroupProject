import java.util.ArrayList;

public class CombatRoom extends Location{
    ArrayList<Enemy> enemies;

    public CombatRoom(String name, int difficulty, int currentLoc, int progress, ArrayList<Enemy> enemies) {
        super(name, difficulty, currentLoc, progress);

        this.enemies = new ArrayList<>();
        this.enemies.addAll(enemies);
    }



}
