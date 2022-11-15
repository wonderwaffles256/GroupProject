/**
 * this class is an extension of the item class
 * it contains methods specifits for objects that function as weapons
 */
public class Weapon extends Item{
    private int damage;

    /**
     * Default constructor for creating a weapon object
     */
    public Weapon() {
        super();
        this.damage = 0;
    }

    /**
     * constructor for weapon object with the data types initialized
     * @param name name of the object
     * @param value value of the object
     * @param damage damage object does
     */

    //constructor given input
    public Weapon(String name, int value, int damage) {
        super(name, value);
        this.damage = damage;
    }

    /**
     * getter for the damage of a weapon
     * @return returns damage of weapon
     */
    //getter / setter
    public int getDamage() {return damage;}

    /**
     * setter for the damage of a weapon
     * @param damage new value for damage of weapon object
     */
    public void setDamage(int damage) {this.damage = damage;}

}
