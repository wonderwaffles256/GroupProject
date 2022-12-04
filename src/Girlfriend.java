import java.util.ArrayList;
import java.util.Random;

public class Girlfriend extends Character{
    private Item medal;           //awarded when you defeat your girlfriend
    private int difficulty;         //use 1,2,3 to denote difficulties
    private ArrayList<String> battleDialogue;
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
     * @param battleDialogue - list of battleDialogue
     */
    public Girlfriend(int HP, String name, Armor armor, Weapon weapon, double critChance, int difficulty, ArrayList<String> battleDialogue, ArrayList<String> flirtDialogue, ArrayList<String> flirtResponses, String flirtSuccess) {
        super(HP, name, armor, weapon, critChance, battleDialogue);
        this.medal = makeMedal(difficulty);
        this.difficulty = difficulty;
        this.flirtSuccess = flirtSuccess;
        flirtLimit = 0;

        this.flirtOptions = new ArrayList<>();          this.flirtResponses = new ArrayList<>();
        this.flirtOptions.addAll(flirtDialogue);        this.flirtResponses.addAll(flirtResponses);

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
        else if(difficulty == 3){
            System.out.println("Ra ra Rasputin\n" + "Lover of the Russian queen\n" + "There was a cat that really was gone");
            System.out.println("Rasputin pulls out a sword and dances like a Barynya dancer while the song Rasputin plays in the background");
            player.setHP(player.getHP()*2/3);
        }
    }

    //TODO: decide how much battleDialogue needs to go in this method (might make more sense to put the end battleDialogue elsewhere)
    public void giveMedal(Player p) {
        System.out.println("After pouring your blood, sweat, and tears onto " + name + "'s bosom in the heat of battle, she finally starts to settle down.");
        System.out.println(""); // cool ending battleDialogue
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
            System.out.println("\u001B[31m" + name + " throws her " + this.weapon.getName() + " at you for " + this.weapon.getDamage() + " Damage.\u001B[0m");
        }

    }

}
