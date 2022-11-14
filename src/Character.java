/**
 * Character is a superclass that gives methods to player, enemy, and girlfriend. It controls the stats of all
 * characters in the game so that they can battle in combat.
 */
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

    /**
     * Main constructor for the class that sets all base stats for a character in the game
     * @param HP - the number of hit-points that a character has
     * @param name - name of the character
     * @param armor - the amount of additional armor that a player has that improves the hp stat
     * @param weapon - weapon give the player a specific amount of damage that is dealt to an enemy.
     * @param critChance - the chance a player has to critically hit an enemy or even miss the enemy completely
     */
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

    /**
     * The fight method lets a character fight another character until one of the two parties wins the battle.
     * The player has the option to fight, flirt, flee, or flask in a fight(heal) until one of the parties finishes the fight
     * @param opponent - the opposing character the current character must battle until a single party wins
     */
    public void fight(Character opponent) {}

    /**
     * equip armor adds the strength value to the hp value to make a player equip a piece of armor.
     * Also, if armor is already equipped it will shift the equipped armor to inventory and the armor
     * will be put on. If the new armor has less strength than the old armor it won't be equipped.
     * @param armor - the armor that a player equips when they get a new piece of armor
     */
    public void equipArmor(Armor armor) {}
}
