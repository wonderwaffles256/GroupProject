import java.util.ArrayList;
import java.util.Random;

/**
 * the player will encounter mini bosses at the end of each location
 */
public class MiniBoss extends Character {
    //1 mini boss per location that you cant flirt with?
    //has better stats then normal boss and ends each location
    private ArrayList<Item> loot = new ArrayList<>();
    private String flirtDialogue;
    private String introDialogue;
    private String deathDialogue;

    /***
     * constructor for a mini boss object
     * @param HP health of boss
     * @param name name of boss
     * @param armor armor of boss
     * @param weapon weapon (damage boss does)
     * @param critChance critical chance of the boss
     * @param loot the items that can be dropped
     * @param flirtDialogue contains the dialogue if the user flirts
     * @param introDialogue the dialogue for when the boss appears
     * @param battleDialogue the dialogue for throughout the battle
     * @param deathDialogue the dialogue for when the enemy dies
     */
    public MiniBoss(int HP, String name, Armor armor, Weapon weapon, double critChance, ArrayList<Item> loot,String flirtDialogue,String introDialogue, ArrayList<String> battleDialogue, String deathDialogue) {
        super(HP,name,armor,weapon,critChance, battleDialogue);
        this.loot.addAll(loot);
        this.flirtDialogue = flirtDialogue;
        this.introDialogue = introDialogue;
        this.deathDialogue = deathDialogue;
    }

    /**
     * cobat with opponent.  They deplete eachothers health until someone hits 0
     * @param opponent - the Character being fought
     */
    public void fight(Character opponent) {
        opponent.setHP(opponent.HP - this.weapon.getDamage());
        if(opponent instanceof Player) {
            System.out.println( "\u001B[31m" + this.name + " smacked you with her " + this.weapon.getName() + " for " + this.weapon.getDamage() + " damage!" + "\u001B[0m");
        }
        else if(opponent instanceof Enemy || opponent instanceof Girlfriend) {
            System.out.println(this.name + " valiantly displayed her affection with violence, dealing " + this.weapon.getDamage() + " damage");
        }
    }

    /**
     * the mini boss will have a chance of dropping items and will always drop CORN for the player
     * @param p the player who can receive the loot
     */
    public void giveLoot(Player p) {
        Random chance = new Random();
        //gives player a random piece of loot from the list
        if(chance.nextInt(100) >= 50) {
            int i = chance.nextInt(loot.size());
            p.addItemPack(loot.get(i));
            System.out.println( "\u001B[33m" + "On the corpse of " + name + ", you found a " + loot.get(i).getName() + "\u001B[0m");
        }
        else {
            p.giveCORN();
        }
        p.setClout(p.getClout() + 0.1);

    }

    /**
     * the mini bosses can never be successfully flirted with, so this dialogue will always print when the user tries to
     */
    public void flirt() {
        System.out.println("You try to flirt with " + "\u001B[31m" + name + "\u001B[0m" + " but he is unmoved by any advances you make upon him");
        System.out.println("\u001B[31m" + flirtDialogue + "\u001B[0m");
    }

    /**
     * when the player encounters the mini boss, they will do some damage and then print out their intro dialogue
     * @param p
     */
    public void introFight(Player p) {
        System.out.println("\u001B[31m" + name + " has appeared!" + "\u001B[0m");
        System.out.println("\u001B[31m" + introDialogue + "\u001B[0m");
        fight(p);
    }

    /**
     * prints out the dialogue for when the mini boss has zero or less health
     */
    public void deathDialogue() {
        System.out.println( "\u001B[31m" + deathDialogue + "\u001B[0m");
    }

}