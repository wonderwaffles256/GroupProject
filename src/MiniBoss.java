import java.util.ArrayList;
import java.util.Random;

public class MiniBoss extends Character {
    //1 mini boss per location that you cant flirt with?
    //has better stats then normal boss and ends each location
    private ArrayList<Item> loot = new ArrayList<>();
    private String flirtDialogue;
    private String introDialogue;
    private String deathDialogue;


    //cool idea
    public MiniBoss(int HP, String name, Armor armor, Weapon weapon, double critChance, ArrayList<Item> loot,String flirtDialogue,String introDialogue, ArrayList<String> battleDialogue, String deathDialogue) {
        super(HP,name,armor,weapon,critChance, battleDialogue);
        this.loot.addAll(loot);
        this.flirtDialogue = flirtDialogue;
        this.introDialogue = introDialogue;
        this.deathDialogue = deathDialogue;
    }


    public void fight(Character opponent) {
        opponent.setHP(opponent.HP - this.weapon.getDamage());
        if(opponent instanceof Player) {
            System.out.println( "\u001B[31m" + this.name + " smacked you with her " + this.weapon.getName() + " for " + this.weapon.getDamage() + " damage!" + "\u001B[0m");
        }
        else if(opponent instanceof Enemy || opponent instanceof Girlfriend) {
            System.out.println(this.name + " valiantly displayed her affection with violence, dealing " + this.weapon.getDamage() + " damage");
        }
    }

    public void giveLoot(Player p) {
        Random chance = new Random();
        //gives player a random piece of loot from the list
        if(chance.nextInt(100) >= 50) {
            int i = chance.nextInt(loot.size());
            p.addItemPack(loot.get(i));
            System.out.println("On the corpse of " + name + ", you found a " + loot.get(i).getName());
        }
        else {
            p.giveCORN();
        }
        p.setClout(p.getClout() + 0.1);

    }
    public void flirt() {
        System.out.println("You try to flirt with " + name + " but he is unmoved by any advances you make upon him");
        System.out.println(flirtDialogue);
    }

    public void introFight(Player p) {
        System.out.println("\u001B[31m" + name + " has appeared!\u001B[0m");
        System.out.println(introDialogue);
        fight(p);
    }

    public void deathDialogue() {
        System.out.println(deathDialogue);
    }

}