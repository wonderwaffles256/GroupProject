import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Character{
    private ArrayList<Item> loot;
    private String flirtRequirement; // (data type TBD)
    private int spawnChance;             // indicates which location this enemy appears in
    private ArrayList<String> flirtDialogue;        //list of options and results from flirting
    private boolean tired;
    private Random r = new Random();

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
    public Enemy(int HP, String name, Armor armor, Weapon weapon, double critChance, ArrayList<Item> loot, String flirtRequirement, int spawnChance, ArrayList<String> battleDialogue, ArrayList<String> flirtDialogue) {
        super(HP,name,armor,weapon,critChance, battleDialogue);
        this.flirtRequirement = flirtRequirement;
        this.spawnChance = spawnChance;

        this.loot = new ArrayList<>();
        this.loot.addAll(loot);

        this.flirtDialogue = new ArrayList<>();
        this.flirtDialogue.addAll(flirtDialogue);

        tired = false;
    }

    //getters
    public ArrayList<Item> getLoot() {return loot;}
    public double getType() {return spawnChance;}
    public String getFlirtRequirement() {return flirtRequirement;}
    public ArrayList<String> getFlirtDialogue() {return flirtDialogue;}
    public ArrayList<String> getBattleDialogue() {return battleDialogue;}
    public boolean getTired() {return tired;}

    //setters
    public void setType(int spawnChance) {this.spawnChance = spawnChance;}
    public void setFlirtRequirement(String flirtRequirement) {this.flirtRequirement = flirtRequirement;}
    public void setTired(boolean tired) {this.tired = tired;}

    /**
     * checks to see if player has met this enemy's flirt requirement for companionship
     * @param option - integer representing the player's choice o flirting options
     * @return - returns the enemy on a success
     */
    public boolean flirtCheck(int option) {
        return flirtDialogue.get(option).equals(flirtRequirement);

    }//implement later
    public Enemy(Enemy e) {
        name = e.name;
        HP = e.HP;
        armor = e.armor;
        weapon = e.weapon;
        critChance = e.critChance;
        loot = e.loot;
        flirtRequirement = e.flirtRequirement;
        spawnChance = e.spawnChance;             // indicates which location this enemy appears in
        battleDialogue = e.battleDialogue;
        flirtDialogue = e.flirtDialogue;
        loot.add(armor);
        loot.add(weapon);
    }

    public void giveLoot(Player p) {
        //gives player a random piece of loot from the list
        if(r.nextInt(100) >= 80) {
            int i = r.nextInt(loot.size());
            p.addItemPack(loot.get(i));
            System.out.println("On the corpse of " + name + ", you found a " + loot.get(i).getName());
        }
        else {
            p.giveCORN(r);
        }
        p.setClout(p.getClout() + 0.1);
        System.out.println("Clout increased by " + 0.1);

    }

    public void fight(Character opponent){
        opponent.setHP(opponent.HP - this.weapon.getDamage());
        if(opponent instanceof Player) {
            System.out.println( "\u001B[31m" + this.name + " whalopped you with its " + this.weapon.getName() + " for " + this.weapon.getDamage() + " damage!" + "\u001B[0m");
        }
        else if(opponent instanceof Enemy || opponent instanceof Girlfriend) {
            System.out.println(this.name + " valiantly displayed its affection with violence, dealing " + this.weapon.getDamage() + " damage");
        }
    }

    public int getSpawnRate() {
        return spawnChance;
    }
}
