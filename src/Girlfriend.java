import java.util.ArrayList;
import java.util.Random;

public class Girlfriend extends Character{
    private String medal;           //awarded when you defeat your girlfriend
    private int difficulty;         //use 1,2,3 to denote difficulties
    private ArrayList<String> dialogue;
    private boolean spAtkUsed;

    public Girlfriend() {
        super();
        medal = null;
        difficulty = 0;
        spAtkUsed = false;
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
        spAtkUsed = false;
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
     * @param player - needed in order to change the Players hp value after being attacked
     */
    public void specialAttack(int difficulty, Character player) {
        System.out.println("I don't know. You've been acting pretty sus lately.");
        System.out.println("I think we have an imposter Among US");
        if(difficulty == 1){
            System.out.println("You have just Scoobied your last Doo");
            player.setHP(player.getHP() - this.getWeapon().getDamage());
            System.out.println("Your Girlfriend hits you with the Mystery Machine dealing" + this.getWeapon().getDamage() + " Damage!");
        }
    }

    /**
     * Returns a string of dialogue from the dialogue list attached to this girlfriend
     * @return String;
     */
    public String dialogue() {return "Impress me or die";}

    /**
     * This method is for when the girlfriend attacks the player
     * @param opponent - the Character being fought
     */
    public void fight(Character opponent){
        Random rand = new Random();
        int chc = rand.nextInt(4) + 1;
        if(chc == 1 && !spAtkUsed){
            this.specialAttack(1, opponent);// change this method for separate difficulties
            spAtkUsed = true;
        }
        else{
            opponent.setHP(opponent.getHP() - this.getWeapon().getDamage());
        }

    }

}
