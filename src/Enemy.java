import java.lang.reflect.Array;
import java.util.Random;
import java.util.ArrayList;

public class Enemy extends Character{
    private ArrayList<Item> loot;
    private String flirtRequirement; // (data type TBD)
    private double spawnChance;             // indicates which location this enemy appears in
    private ArrayList<String> dialogue;

    //default constructor
    public Enemy() {
        super();
        loot = new ArrayList<>();
        flirtRequirement = null;
         spawnChance = 0;
    }

    //constructor given input
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

    //should we create addLoot method or just standard setter?


    /**
     * Returns a string of randomly generated dialogue
     * @return String;
     */
    public String dialogue() {return "Cool Dialogue";}

    //implement seduction method (TBD)
}
