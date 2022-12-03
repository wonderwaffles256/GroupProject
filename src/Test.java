import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;


public class Test {
    public static void main(String[] args) {

        Armor noArmor = new Armor("none", 0, 0, "Nothing cheaper than a birthday suit");
        Weapon magicWand = new Weapon("Magic Wand", 15, 1,"look this doesn't mean magic is real, i just ran out of ideas for weapons");
        Weapon magicWand2 = new Weapon("Magic Wand", 15, 10,"look this doesn't mean magic is real, i just ran out of ideas for weapons");

        String pSuccess = "*Chimes happily and flies close to you*";
        ArrayList<Item> pLoot = new ArrayList<>();
        ArrayList<String> pBattleDialogue = new ArrayList<>();
        pBattleDialogue.add("*Threatening orb of light approaches*");
        ArrayList<String> pFlirtDialogue = new ArrayList<>();
        pFlirtDialogue.add("1 -  Joke about burning down the forest \n" + "2 - compliment its radiance \n" + "3 - admire the beauty of nature");
        pFlirtDialogue.add("*flies around looking even angrier*");
        pFlirtDialogue.add("*continues shining brilliantly*");
        pFlirtDialogue.add(pSuccess);
        Enemy pixie1 = new Enemy (15, "Pixie", noArmor,magicWand2 , 1, pLoot,pSuccess,6,pBattleDialogue,pFlirtDialogue);
        Enemy pixie2 = new Enemy (15, "Pixie", noArmor,magicWand2 , 1, pLoot,pSuccess,6,pBattleDialogue,pFlirtDialogue);
        Player player = new Player(1000, "test", noArmor, magicWand, 10);


        player.flirt(pixie1,player);
        while(pixie2.getHP() > 0) {
            player.fight(pixie2);
            pixie2.fight(player);
        }

    }


}
