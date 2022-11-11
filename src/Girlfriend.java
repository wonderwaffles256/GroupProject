import java.util.ArrayList;

public class Girlfriend extends Character{
    private String medal;           //awarded when you defeat your girlfriend
    private int difficulty;         //use 1,2,3 to denote difficulties
    private ArrayList<String> dialogue;

    public Girlfriend() {
        super();
        medal = null;
        difficulty = -1;
    }

    public Girlfriend(int HP, String name, Armor armor, Weapon weapon, double critChance, String medal, int difficulty, ArrayList<String> dialogue) {
        super(HP, name, armor, weapon, critChance);
        this.medal = medal;
        this.difficulty = difficulty;

        this.dialogue = new ArrayList<>();
        this.dialogue.addAll(dialogue);
    }



    /* TO DO:
        - unique attack method (based on difficulty)
        - dialogue method (based on difficulty)
     */
}
