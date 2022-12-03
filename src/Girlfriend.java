import java.util.ArrayList;
import java.util.Random;

public class Girlfriend extends Character{
    private Item medal;           //awarded when you defeat your girlfriend
    private int difficulty;         //use 1,2,3 to denote difficulties
    private ArrayList<String> dialogue;
    private boolean spAtkUsed;
    private ArrayList<String> flirtOptions;         //Holds a list of strings to display flirting options to the player
    private ArrayList<String> flirtResponses;       //Holds a list of responses to each option plus an extra at index 0 for a successful flirt
    private String flirtSuccess;                    //string of numbers indicating which options from the flirtOptions list are correct
    private int flirtLimit;

    public Girlfriend() {
        super();
        medal = null;
        difficulty = 0;
        spAtkUsed = false;
        flirtLimit = 0;
    }

    /**
     * constructor
     * @param HP - number of health points
     * @param name - name of the girlfriend
     * @param armor - armor worn by girlfriend
     * @param weapon - weapon wielded by girlfriend
     * @param critChance - chance to land a critical hit
     * @param difficulty - level of difficulty related to the girlfriend
     * @param dialogue - list of dialogue
     */
    public Girlfriend(int HP, String name, Armor armor, Weapon weapon, double critChance, int difficulty, ArrayList<String> dialogue, ArrayList<String> flirtDialogue, ArrayList<String> flirtResponses, String flirtSuccess) {
        super(HP, name, armor, weapon, critChance);
        this.medal = makeMedal(difficulty);
        this.difficulty = difficulty;
        this.flirtSuccess = flirtSuccess;
        flirtLimit = 0;

        this.dialogue = new ArrayList<>();      this.flirtOptions = new ArrayList<>();          this.flirtResponses = new ArrayList<>();
        this.dialogue.addAll(dialogue);         this.flirtOptions.addAll(flirtDialogue);        this.flirtResponses.addAll(flirtResponses);

        spAtkUsed = false;
    }

    public Item makeMedal(int difficulty) {
        switch (difficulty) {
            case 1 -> {return new Item("Bronze Medal", 100, "Participation award");}
            case 2 -> {return new Item("Silver Medal", 250, "A shiny silver medallion. The back says 'made in Taiwan'");}
            case 3 -> {return new Item("Gold Medal", 500, "As shiny as a freshly buffed bald man's forehead. The ultimate flex.");}
        }
        return null;
    }

    //getters
    public int getDifficulty() {return difficulty;}
    public Item getMedal() {return medal;}
    public ArrayList<String> getFlirtOptions() {return flirtOptions;}
    public ArrayList<String> getFlirtResponses() {return flirtResponses;}
    public String getFlirtSuccess() {return flirtSuccess;}
    public int getFlirtLimit() {return flirtLimit;}

    //setter
    public void setDifficulty(int difficulty) {this.difficulty = difficulty;}
    public void setFlirtLimit(int limit) {flirtLimit = limit;}

    /**
     * Alternate attack specifically for the girlfriend that increases in strength based on its difficulty.
     * Girlfriends have a low chance of using this attack.
     * @param difficulty;
     * @param player - needed in order to change the Players hp value after being attacked
     */
    public void specialAttack(int difficulty, Character player) {//more stuff for different difficulties
        System.out.println("I don't know. You've been acting pretty sus lately.");
        System.out.println("I think we have an imposter Among US");
        if(difficulty == 1){
            System.out.println("You have just Scoobied your last Doo");
            player.setHP(player.HP - this.weapon.getDamage());
            System.out.println("Your Girlfriend hits you with the Mystery Machine dealing" + this.weapon.getDamage() + " Damage!");
        }
    }

    /**
     * Returns a string of dialogue from the dialogue list attached to this girlfriend
     * @return String;
     */
    //TODO: have this return a string from the battle dialogue list
    public String dialogue() {return "Impress me or die";}

    //TODO: decide how much dialogue needs to go in this method (might make more sense to put the end dialogue elsewhere)
    public void giveMedal(Player p) {
        System.out.println("After pouring your blood, sweat, and tears onto " + name + "'s bosom in the heat of battle, she finally starts to settle down.");
        System.out.println(""); // cool ending dialogue
        p.addItemPack(medal);
    }

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
            opponent.setHP(opponent.HP - this.weapon.getDamage());
            System.out.println("Your girlfriend throws a " + this.weapon.getName() + " at you for " + this.weapon.getDamage() + " Damage.");
        }

    }

}
