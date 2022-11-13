import java.sql.Array;
import java.util.ArrayList;

public class Player extends Character{
    private double clout;                   //clout will start at 0
    private int CORN;                       //CORN will start at 0
    private ArrayList<Item> itemPack;
    private ArrayList<Character> companions;

    //default constructor
    public Player() {
        super();
        clout = 0;
        CORN = 0;
        itemPack = new ArrayList<>();
        companions = new ArrayList<>();
    }

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

    //getters
    public double getClout() {return clout;}
    public int getCORN() {return CORN;}
    public ArrayList<Item> getItemPack() {return itemPack;}
    public ArrayList<Character> getCompanions() {return companions;}

    //setters
    public void setCORN(int CORN) {this.CORN = CORN;}
    public void setClout(double clout) {this.clout = clout;}
    public void acquireCorn(int corn){CORN = corn + CORN;}

    //player flees combat, losing clout
    public void flight() {}

    //player attempts to flirt with enemy. If requirements are met, the enemy joins your group of companions
    public void flirt() {}

}

