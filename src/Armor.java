/**
 * A subclass of item that takes care of the armor that a player can equip to improve their hp value
 */
public class Armor extends Item{
    private int strength;

    /**
     * constructor
     */
    public Armor() {
        super();
        strength = 0;
    }

    /**
     * Requires three parameters of name, value, and strength the strength value being the amount of hp that the armor
     * gives the player
     * @param name - name of the armor
     * @param value - value of the armor
     * @param strength - the amount of hp given to player by armor
     */
    public Armor(String name, int value, int strength) {
        super(name, value);
        this.strength = strength;
    }

    //get/set armor strength
    public int getStrength() {return strength;}
    public void setStrength(int strength) {this.strength = strength;}

}
