import java.util.ArrayList;

public class Girlfriend extends Character{
    private String medal;           //awarded when you defeat your girlfriend
    private int difficulty;         //use 1,2,3 to denote difficulties
    private ArrayList<String> dialogue;

    public Girlfriend() {
        super();
        medal = null;
        difficulty = 0;
    }

    /**
     * constructor
     * @param HP - number of health points
     * @param name - name of the girlfriend
     * @param armor - armor worn by girlfriend
     * @param weapon - weapon wielded by girlfriend
     * @param critChance - chance to land a critical hit
     * @param medal - award obtained by defeating your girlfriend
     * @param difficulty - level of difficulty related to the girlfriend
     * @param dialogue - list of dialogue
     */
    public Girlfriend(int HP, String name, Armor armor, Weapon weapon, double critChance, String medal, int difficulty, ArrayList<String> dialogue) {
        super(HP, name, armor, weapon, critChance);
        this.medal = medal;
        this.difficulty = difficulty;

        this.dialogue = new ArrayList<>();
        this.dialogue.addAll(dialogue);
    }

    //getters
    public int getDifficulty() {return difficulty;}
    public String getMedal() {return medal;}

    //setter
    public void setDifficulty(int difficulty) {this.difficulty = difficulty;}

    /**
     * Alternate attack specifically for the girlfriend that increases in strength based on its difficulty.
     * Girlfriends have a low chance of using this attack.
     * @param difficulty;
     */
    public void specialAttack(int difficulty) {}

    /**
     * Returns a string of dialogue from the dialogue list attached to this girlfriend
     * @return String;
     */
    public String dialogue() {return "Impress me or die";}

}
