import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Character is a superclass that gives methods to player, enemy, and girlfriend. It controls the stats of all
 * characters in the game so that they can battle in combat.
 */
public abstract class Character {
    protected int HP;
    protected String name;
    protected Armor armor;
    protected Weapon weapon;
    protected double critChance;
    protected int maxHP;
    protected ArrayList<String> battleDialogue;

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
    public Character(int HP, String name, Armor armor, Weapon weapon, double critChance, ArrayList<String> battleDialogue) {
        maxHP = HP + armor.getStrength();
        this.HP = maxHP;
        this.name = name;
        this.armor = armor;
        this.weapon = weapon;
        this.critChance = critChance;
        this.battleDialogue = new ArrayList<>();
        this.battleDialogue.addAll(battleDialogue);
    }

    //getters
    public int getHP() {return HP;}
    public int getMaxHP() {return maxHP;}
    public String getName() {return name;}
    public Weapon getWeapon() {return weapon;}
    public Armor getArmor() {return armor;}
    public double getCritChance() {return critChance;}

    //setters
    public void setCritChance(double critChance) {this.critChance = critChance;}
    public void setWeapon(Weapon weapon) {this.weapon = weapon;}
    public void setArmor(Armor armor) {this.armor = armor;}
    public void setHP(int HP) {this.HP = HP;}
    public void setMaxHP(int maxHP) {this.maxHP = maxHP;}
    public void setName(String name) {this.name = name;}

    //uses current weapon to fight an enemy, girlfriend, or player

    /**
     * The fight method lets a character fight another character to the death.
     * The player has the option to fight, flirt, flee, or flask in combat until one of the parties finishes the fight
     * @param opponent - the Character being fought
     */
    public abstract void fight(Character opponent);

    public void dialogue() {
        Random r = new Random();
        int i = r.nextInt(this.battleDialogue.size());
        System.out.println(this.battleDialogue.get(i) + "    - " + name);
    }

    /**
     * equip armor adds the strength value to the hp value to make a player equip a piece of armor.
     * Also, if armor is already equipped it will shift the equipped armor to inventory and the new set
     * will be put on. If the new armor has less strength than the old armor it won't be equipped.
     * @param armor - a newly acquired set of armor
     */
    public void equipArmor(Armor armor) {}//implement later

    public String printInfo() {
        return("\u001B[34m" + name + " ___ HP: " + HP + "   Weapon: " + weapon.getName() + " - " + weapon.getDamage() + " dmg ______ " + weapon.getDescription() + "\u001B[0m");
    }
}
