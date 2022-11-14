public class Character {
    private int HP;
    private String name;
    private Armor armor;
    private Weapon weapon;
    private double critChance;

    public Character() {
        HP = 0;
        name = null;
        armor = new Armor();
        weapon = new Weapon();
        critChance = 0;
    }

    //
    public Character(int HP, String name, Armor armor, Weapon weapon, double critChance) {
        this.HP = HP;
        this.name = name;
        this.armor = armor;
        this.weapon = weapon;
        this.critChance = critChance;
    }

    //getters
    public int getHP() {return HP;}
    public String getName() {return name;}
    public Weapon getWeapon() {return weapon;}
    public Armor getArmor() {return armor;}
    public double getCritChance() {return critChance;}

    //setters
    public void setCritChance(double critChance) {this.critChance = critChance;}
    public void setWeapon(Weapon weapon) {this.weapon = weapon;}
    public void setArmor(Armor armor) {this.armor = armor;}
    public void setHP(int HP) {this.HP = HP;}
    public void setName(String name) {this.name = name;}

    //uses current weapon to fight an enemy, girlfriend, or player
    public void fight(Character opponent) {}

    //adds armor strength to current health
    public void equipArmor() {}
}
