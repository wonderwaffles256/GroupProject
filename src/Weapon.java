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
    public Weapon(String name, int value, int damage, String description) {
        super(name, value, description);
        this.damage = damage;
    }

    /**
     * This is just a simple copy constructor for a weapon
     * @param w - a weapon that is being copied
     */
    public Weapon(Weapon w) {
        super(w.getName(), w.getValue(), w.getDescription());
        this.damage = w.getDamage();
    }

    /**
     * getter for the damage of a weapon
     * @return returns damage of weapon
     */
    //getter / setter
    public int getDamage() {return damage;}

}
