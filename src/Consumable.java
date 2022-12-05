public class Consumable extends Item{
    private int healing;

    /**
     * Default constructor for creating a consumable object
     */
    public Consumable() {
        super();
        this.healing = 0;
    }

    /**
     * constructor for healing object with the data types initialized
     * @param name name of the object
     * @param value value of the object
     * @param healing how much healing the object gives to a player
     */
    public Consumable(String name, int value, int healing, String description) {
        super(name, value, description);
        this.healing = healing;
    }

    /**
     * getter for the healing of the object
     * @return returns healing of the object
     */
    //getter
    public int getHealing() {return healing;}

}
