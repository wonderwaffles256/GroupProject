import java.sql.Array;
import java.util.ArrayList;

public class Player extends Character{
    private double clout;                   //clout will start at 0
    private int CORN;                       //CORN will start at 0
    private ArrayList<Item> itemPack;
    private ArrayList<Character> companions;

    /**
     * initializes the player object with no parameters
     */
    //default constructor
    public Player() {
        super();
        clout = 0;
        CORN = 0;
        itemPack = new ArrayList<>();
        companions = new ArrayList<>();
    }

    /**
     *
     * @param HP health of player
     * @param name name of player
     * @param armor armor rating of player
     * @param weapon weapon held by player
     * @param critChance chance of landing critical hit
     * @param itemPack arraylist of items the player has
     * @param companions arraylist of all the companions the player has
     */

    //constructor given input
    public Player(int HP, String name, Armor armor, Weapon weapon, double critChance, ArrayList<Item> itemPack, ArrayList<Character> companions) {
        super(HP, name, armor, weapon, critChance);
        clout = 0;
        CORN = 0;
        this.itemPack = new ArrayList<>();
        this.companions = new ArrayList<>();

        this.itemPack.addAll(itemPack);
        this.companions.addAll(companions);
    }

    /**
     * getter
     * @return clout
     */
    //getters
    public double getClout() {return clout;}

    /**
     * getter
     * @return corn value
     */
    public int getCORN() {return CORN;}

    /**
     * getter
     * @return arraylist of items
     */
    public ArrayList<Item> getItemPack() {return itemPack;}

    /**
     * getter
     * @return arraylist of companions
     */
    public ArrayList<Character> getCompanions() {return companions;}

    //setters

    /**
     * setter
     * @param CORN sets value for corn
     */
    public void setCORN(int CORN) {this.CORN = CORN;}

    /**
     * setter
     * @param clout sets value for clout
     */
    public void setClout(double clout) {this.clout = clout;}

    /**
     * when user obtains corn it sums the newly obtained bits with the existing amount
     * @param corn adds new corn onto existing
     */
    public void acquireCorn(int corn){CORN = corn + CORN;}

    /**
     * plauer flees combat
     * this causes a decrese in clout
     */
    //player flees combat, losing clout
    public void flight() {}

    /**
     * player flirts with enemy
     * if successful then enemy becomes a companion
     */

    //player attempts to flirt with enemy. If requirements are met, the enemy joins your group of companions
    public void flirt() {}

    //use some number of flasks/potion items to heal HP
    public void flask() {}

    //equips a weapon of choice
    public void equipWeapon() {}

}

