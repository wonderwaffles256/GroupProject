import java.lang.reflect.Array;
import java.util.Random;
import java.util.ArrayList;

public class Enemy extends Character{
    private ArrayList<Item> loot;
    private String flirtRequirement; // (data type TBD)
    private double spawnChance;             // indicates which location this enemy appears in
    private ArrayList<String> dialogue;

    /**
     * default constructor
     */
    public Enemy() {
        super();
        loot = new ArrayList<>();
        flirtRequirement = null;
         spawnChance = 0;
    }

    /**
     *
     * @param HP - # of health points
     * @param name - name of the enemy
     * @param armor - armor worn by the enemy
     * @param weapon - weapon wielded by the enemy
     * @param critChance - chance to land a critical hit
     * @param loot - list of items/CORN held by an enemy (one is gained upon defeat)
     * @param flirtRequirement - string representing the requirement for a successful flirt (usually an item)
     * @param spawnChance - rate at which this enemy spawns at a location
     * @param dialogue - list of dialogue related to the enemy
     */
    public Enemy(int HP, String name, Armor armor, Weapon weapon, double critChance, ArrayList<Item> loot, String flirtRequirement, double spawnChance, ArrayList<String> dialogue) {
        super(HP,name,armor,weapon,critChance);
        this.flirtRequirement = flirtRequirement;
        this.spawnChance = spawnChance;

        this.loot = new ArrayList<>();
        this.loot.addAll(loot);

        this.dialogue = new ArrayList<>();
        this.dialogue.addAll(dialogue);
    }

    //getters
    public ArrayList<Item> getLoot() {return loot;}
    public double getType() {return spawnChance;}
    public String getFlirtRequirement() {return flirtRequirement;}

    //setters
    public void setType(double spawnChance) {this.spawnChance = spawnChance;}
    public void setFlirtRequirement(String flirtRequirement) {this.flirtRequirement = flirtRequirement;}

    /**
     * Returns a string of randomly generated dialogue
     * @return String;
     */
    public String dialogue() {return "Cool Dialogue";}//think of more cool dialogue

    /**
     * checks to see if player has met this enemy's flirt requirement for companionship
     * @param flirtRequirement - string representing the requirement for a successful flirt (usually an item)
     * @return - returns the enemy on a success
     */
    public Enemy flirtSuccess(String flirtRequirement) {
        return new Enemy();
    }//implement later

    public void fight(Character opponent){
        opponent.setHP(opponent.getHP() - this.getWeapon().getDamage());
        System.out.println(this.getName() + " whalopped you with its " + this.getWeapon().getName() + " for " + this.getWeapon().getDamage() + " damage!");
    }
}
