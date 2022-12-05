import java.util.ArrayList;
import java.util.Random;

public class Girlfriend extends Character{
    private int difficulty;         //use 1,2,3 to denote difficulties
    private boolean spAtkUsed;
    private ArrayList<String> flirtOptions;         //Holds a list of strings to display flirting options to the player
    private ArrayList<String> flirtResponses;       //Holds a list of responses to each option plus an extra at index 0 for a successful flirt
    private String flirtSuccess;                    //string of numbers indicating which options from the flirtOptions list are correct
    private int flirtLimit;

    public Girlfriend() {
        super();
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
        this.difficulty = difficulty;
        this.flirtSuccess = flirtSuccess;
        flirtLimit = 0;

        this.flirtOptions = new ArrayList<>();          this.flirtResponses = new ArrayList<>();
        this.flirtOptions.addAll(flirtDialogue);        this.flirtResponses.addAll(flirtResponses);

        spAtkUsed = false;
    }

    //getters
    public int getDifficulty() {return difficulty;}
    public ArrayList<String> getFlirtOptions() {return flirtOptions;}
    public ArrayList<String> getFlirtResponses() {return flirtResponses;}
    public String getFlirtSuccess() {return flirtSuccess;}
    public int getFlirtLimit() {return flirtLimit;}

    //setter
    public void setFlirtLimit(int limit) {flirtLimit = limit;}

    /**
     * Alternate attack specifically for the girlfriend that increases in strength based on its difficulty.
     * Girlfriends have a low chance of using this attack.
     * @param difficulty;
     * @param player - needed in order to change the Players hp value after being attacked
     */
    public void specialAttack(int difficulty, Character player) {//more stuff for different difficulties
        System.out.println("It looks like " + this.getName() + " is gearing up for a special attack");
        if(difficulty == 1){
            System.out.println("\u001B[31m" + "You have just Scoobied your last Doo");
            player.setHP(player.HP - this.weapon.getDamage());
            System.out.println("Your Girlfriend hits you with the Mystery Machine dealing" + this.weapon.getDamage() + " damage!" + "\u001B[0m");
        }
        else if(difficulty == 2) {
            System.out.println("\u001B[31m" + "Ra ra Rasputin\n" + "Lover of the Russian queen\n" + "There was a cat that really was gone");
            System.out.println("Rasputin pulls out a sword and dances like a Barynya dancer while the song Rasputin plays in the background, dealing " + player.getHP()/3 + " damage!\u001B[0m");
            player.setHP(player.getHP()*2/3);
        }
        else if(difficulty == 3){
            player.setHP(player.getHP()/3);
            System.out.println("\u001B[31mPadme threatens to break up with you, dealing " + player.getHP()*2/3 + " damage!\u001B[0m");
        }
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
            System.out.println("\u001B[31m" + name + " throws her " + this.weapon.getName() + " at you for " + this.weapon.getDamage() + " Damage." + "\u001B[0m");
        }

    }

}
