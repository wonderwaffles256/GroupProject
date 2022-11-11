public class Armor extends Item{
    private int strength;

    //default constructor
    public Armor() {
        super();
        strength = 0;
    }

    //constructor given input
    public Armor(String name, int value, int strength) {
        super(name, value);
        this.strength = strength;
    }

    //get/set armor strength
    public int getStrength() {return strength;}
    public void setStrength(int strength) {this.strength = strength;}

}
