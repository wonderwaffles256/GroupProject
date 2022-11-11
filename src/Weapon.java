public class Weapon extends Item{
    private int damage;

    //default constructor
    public Weapon() {
        super();
        this.damage = 0;
    }

    //constructor given input
    public Weapon(String name, int value, int damage) {
        super(name, value);
        this.damage = damage;
    }

    //getter / setter
    public int getDamage() {return damage;}

    public void setDamage(int damage) {this.damage = damage;}

}
