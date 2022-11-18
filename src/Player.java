import java.sql.Array;
import java.util.ArrayList;

public class Player extends Character{
    private double clout;                   //clout will start at 0
    private int CORN;                       //CORN will start at 0
    private ArrayList<Item> itemPack;
    private ArrayList<Character> companions;

    /**
     * default constructor
     * initializes the player object with no parameters
     */
    public Player() {
        super();
        clout = 1;
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
     * Player's version of the fight method. Multiplies damage by their current clout modifier.
     * @param opponent - the Character being fought
     */
    public void fight(Character opponent){
        double dmg = ((double) this.getWeapon().getDamage()) * clout;
        opponent.setHP((int) Math.round((double) opponent.getHP() - dmg));
        System.out.println("You dealt " + Math.round(dmg) + "!");
    }

    /**
     * player flees combat
     * this act of cowardice decreases their clout
     */
    public void flee() {
        this.clout -= this.clout - 0.2;
        System.out.println("How can you expect to impress a girl if you cannot impress yourself?.\n" +
                           "CLOUT reduced by 0.2!");
    }

    /**
     * player flirts with enemy
     * if successful then enemy becomes a companion
     */
    public void flirt() {}

    /**
     * player uses items from his itemPack to heal hp or gain some other buff
     */
    public void flask() {
        if(this.itemPack.isEmpty()) {
            System.out.println("You ain't got nothin boy!\n" + "Go get some junk!");
        }
        else{
            displayItems();

        }

    }

    public void displayItems() {
        for(int i = 0; i < this.itemPack.size(); i++) {
            System.out.println("Item " + i + ": " + this.itemPack.get(i).getName());
        }
    }

    /**
     * allows the user to equip a weapon of their choice
     */
    public void equipWeapon() {}

    /**
     * allows player to choose one of a companions to fight for them once during a battle
     */
    public void useCompanions() {}

}