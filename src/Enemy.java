import java.util.ArrayList;

public class Enemy extends Character{
    private ArrayList<Item> loot;
    private String flirtRequirement; // (data type TBD)
    private double spawnChance;             // indicates which location this enemy appears in
    private ArrayList<String> battleDialogue;       //list of dialogue meant to be displayed in battle
    private ArrayList<String> flirtDialogue;        //list of options and results from flirting

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
     * @param battleDialogue - list of battleDialogue related to the enemy
     * @param flirtDialogue - list of flirtDialogue related to enemy
     */
    public Enemy(int HP, String name, Armor armor, Weapon weapon, double critChance, ArrayList<Item> loot, String flirtRequirement, double spawnChance, ArrayList<String> battleDialogue, ArrayList<String> flirtDialogue) {
        super(HP,name,armor,weapon,critChance);
        this.flirtRequirement = flirtRequirement;
        this.spawnChance = spawnChance;

        this.loot = new ArrayList<>();
        this.loot.addAll(loot);

        this.battleDialogue = new ArrayList<>();
        this.battleDialogue.addAll(battleDialogue);

        this.flirtDialogue = new ArrayList<>();
        this.flirtDialogue.addAll(flirtDialogue);
    }

    //getters
    public ArrayList<Item> getLoot() {return loot;}
    public double getType() {return spawnChance;}
    public String getFlirtRequirement() {return flirtRequirement;}
    public ArrayList<String> getFlirtDialogue() {return flirtDialogue;}
    public ArrayList<String> getBattleDialogue() {return battleDialogue;}

    //setters
    public void setType(double spawnChance) {this.spawnChance = spawnChance;}
    public void setFlirtRequirement(String flirtRequirement) {this.flirtRequirement = flirtRequirement;}

    /**
     * Returns a string of randomly generated battleDialogue
     * @return String;
     */
    public String dialogue() {return "Cool Dialogue";}//think of more cool battleDialogue

    /**
     * checks to see if player has met this enemy's flirt requirement for companionship
     * @param flirtRequirement - string representing the requirement for a successful flirt (usually an item)
     * @return - returns the enemy on a success
     */
    public Enemy flirtSuccess(String flirtRequirement) {
        return new Enemy();
    }//implement later

    public void fight(Character opponent){
        opponent.setHP(opponent.HP - this.weapon.getDamage());
        System.out.println( "\u001B[31m" + this.name + " whalopped you with its " + this.weapon.getName() + " for " + this.weapon.getDamage() + " damage!" + "\u001B[0m");
    }
}
