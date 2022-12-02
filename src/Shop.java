import java.util.ArrayList;
import java.util.Scanner;

/**
 * by obtaining in game currency players are able to buy and sell items
 */
public class Shop {
    private ArrayList<Weapon> inventoryW;
    private ArrayList<Armor> inventoryA;
    private ArrayList<Consumable> inventoryC;
    Scanner scnr = new Scanner(System.in);


    public Shop(ArrayList<Item> items) {
        inventoryW = new ArrayList<>();
        inventoryA = new ArrayList<>();
        inventoryC = new ArrayList<>();

        for(Item I : items) {
            if (I instanceof Armor) {
                inventoryA.add((Armor) I);
            }
            else if (I instanceof Weapon) {
                inventoryW.add((Weapon) I);
            }
           else if (I instanceof Consumable) {
                inventoryC.add((Consumable) I);
            }
        }
    }

    /**
     * prints out all the available Consumables in the shop
     */
    public void displayC() {
        int count = 0;
        for (Consumable sell : inventoryC) {
            System.out.println("We are selling  " + sell.getName() + " a healing item for " + sell.getValue() + " CORN. This item heals " + sell.getHealing());
            System.out.println("Item number: " + count);
            System.out.println(sell.getName() + " description: " + sell.getDescription());
            count++;
        }

        System.out.println("Please input the number of the item to buy [#] or a negative value to leave the shop [-1]");
    }

    //TODO: simplify dialogue in these methods
    /**
     * prints out all the available Weapons in the shop
     */
    public void displayW() {
        int count = 0;
        for (Weapon sell : inventoryW) {
            System.out.println("We are selling " + sell.getName() + " a weapon for " + sell.getValue() + " CORN. This item deals " + sell.getDamage() + " damage.");
            System.out.println("Item number: " + count);
            System.out.println(sell.getName() + " description: " + sell.getDescription());
            count++;
        }

        System.out.println("Please input the number of the weapon you would like to buy [#] or a negative value to leave this shop [-1]");
    }

    /**
     * prints out all the available Weapons in the shop
     */
    public void displayA() {
        int count = 0;
        for (Armor sell : inventoryA) {
            System.out.println("We are selling  " + sell.getName() + " a healing item for " + sell.getValue() + " CORN. This item heals " + sell.getStrength());
            System.out.println("Item number: " + count);
            System.out.println(sell.getName() + " description: " + sell.getDescription());
            count++;
        }

        System.out.println("Please input the number of the armor you would like to buy [#] or a negative value to leave this shop [-1]");
    }

    /**
     * a menu for navigating the shop that lets the player buy and sell
     */
    public void shopMenu(Player p) {
        char BSL = 'B';
        System.out.println("Welcome to the SHOP also known as SHEETZ.");
        while (BSL != 'L') {
            System.out.println("Would you like to buy[B], sell[S], or");
            System.out.println("would you like to leave[L]");
            BSL = scnr.nextLine().charAt(0);
            try {
                if (BSL == 'B') {
                    buyMenu(p);
                } else if (BSL == 'S') {
                    sell(p);
                } else if (BSL == 'L') {
                    System.out.println("Thanks for coming. Hope you can reach ya girl, whippersnapper");
                } else {
                    System.out.println("I don't understand what you just said. Try my suggested answers...Some people's kids");
                }
            }catch(Exception e){
                System.out.println("Sorry fella something didn't work quite right try that again.");
            }
        }
    }

    /**
     * This is yet another menu to separate the things a player can buy from the shop
     *
     * @param p a player that wants to buy the item from the shop - mainly used to carry to the final buy methods
     */
    public void buyMenu(Player p) {
        System.out.println("So, ya wanna buy do ya. Wanna buy a healing consumable[C], weapon[W], or some Armor[A]");
        char choice = scnr.nextLine().charAt(0);
            if (choice == 'C') {
                buyC(p);
            } else if (choice == 'W') {
                buyW(p);
            } else if (choice == 'A') {
                buyA(p);
            } else {
                System.out.println("Guessing that means you changed ur mind then huh.");
            }
    }

    /**
     * This method allows a player to buy consumables from the shop
     * They never run out, so you can always buy more
     *
     * @param p - used to equip weapon and to subtract corn from to purchase the desired weapon the player wants
     */
    public void buyC(Player p) {
        System.out.println("Alright then here are all the consumables we have for sale pick the [#] of the one you want.    Hope they ain't expired.");
        displayC();
        System.out.println("Also, ya have " + p.getCORN() + " to spend.");
        int choice = scnr.nextInt();
        scnr.nextLine();
        System.out.println();
        if (choice > inventoryC.size() || choice < 0) {
            System.out.println("Sorry, fella that ain't in stock");
        } else {
            Consumable c = inventoryC.get(choice);
            if (p.getCORN() < c.getValue()) {
                System.out.println("Bon Ami but not Bon enough. Come back with more CORN.");
            } else {
                p.addItemPack(c);
                p.setCORN(p.getCORN() - c.getValue());
                System.out.println("Pleasure doing business with ya");
            }
        }
    }

    /**
     * This method allows a player to buy a weapon from the shop
     *
     * @param p - the player who is buying the weapon from the shop
     */
    public void buyW(Player p) {
        System.out.println("Alright then here are all the weapons we have for sale print the [#] of the weapon you want.    Make sure to watch the stats. ");
        displayW();
        System.out.println("Thought you should know but yur current weapon does " + p.getWeapon().getDamage() + " damage. Might help ya pick.");
        System.out.println("Also, ya have " + p.getCORN() + " to spend.");
        int choice = scnr.nextInt();
        scnr.nextLine();
        if (choice > inventoryW.size() || choice < 0) {
            System.out.println("Sorry, fella that ain't in stock");
        } else {
            Weapon w = inventoryW.get(choice);
            if (p.getCORN() < w.getValue()) {
                System.out.println("Pathetic. Can't even afford it.");
            } else {
                p.setCORN(p.getCORN() - w.getValue());
                inventoryW.remove(choice);
                System.out.println("Wanna equip ya new damage dealer, boy. Yes[Y] or no[N].");
                char equip = scnr.nextLine().charAt(0);
                if (equip == 'Y') {
                    System.out.println("Ight yur weapon is equipped and ya old one is in yur bag.");
                    p.equipWeapon(w);
                } else {
                    System.out.println("Imma just put her in ya bag then.");
                    p.addItemPack(w);
                }
            }
        }
    }

    /**
     * This method allows a player to buy armor from the shop
     *
     * @param p - the player who is buying the armor from the shop
     */
    public void buyA(Player p) {
        System.out.println("Alright then here is all mi armor laddy print da [#] of the armor ye want.    Make sure to watch the stats. ");
        displayA();
        System.out.println("Thought you should know but ya current armor has " + p.getArmor().getStrength() + " strength. Might help ye pick.");
        System.out.println("Also, ya have " + p.getCORN() + " to spend.");
        int choice = scnr.nextInt();
        scnr.nextLine();
        System.out.println();
        if (choice > inventoryA.size() || choice < 0) {
            System.out.println("Sorry, fella that ain't in stock");
        } else {
            Armor a = inventoryA.get(choice);
            if (p.getCORN() < a.getValue()) {
                System.out.println("This ain't a charity laddy come back with more CORN");
            } else {
                p.setCORN(p.getCORN() - a.getValue());
                inventoryA.remove(choice);
                System.out.println("Wanna equip ye new drip, lad. Yes[Y] or no[N].");
                char equip = scnr.nextLine().charAt(0);
                if (equip == 'Y') {
                    System.out.println("Just go redress yur scury butt.");
                    p.equipArmor(a);
                } else {
                    System.out.println("Imma just put her in ya bag then.");
                    p.addItemPack(a);
                }
            }
        }
    }

    /**
     * This method allows a player to sell an item to the shop keep for 5/6 of the item's value
     * @param p - player who wants to sell his own items and needs to get CORN from the sold items
     */
    public void sell(Player p) {
        System.out.println("So ya wanna sell sum do ya. All right what do ya wanna sell?");
        int count = 0;
        for(Item item : p.getItemPack()){
            System.out.println("This is item number: " + count);
            System.out.println(item.getName() + " has a sell for " + item.getValue()*5/6 + " CORN.");
            if(item instanceof Consumable c){
                System.out.println("This item heals for " + c.getHealing() + ".");
            }
            else if(item instanceof Weapon w){
                System.out.println("This item deals " + w.getDamage() + " damage.");
            }
            else if(item instanceof Armor a){
                System.out.println("This item has a strength of " + a.getStrength() + ".");
            }
            count++;
        }
        System.out.println("Please print the number of the item you would like to sell.");
        int choose = scnr.nextInt();
        scnr.nextLine();
        System.out.println();
        if(choose < 0 || choose > p.getItemPack().size()){
            System.out.println("Sorry fella but that item doesn't exist");
        }
        else{
            System.out.println("Pleasure doing business wit ya bud. Have day.");
            p.setCORN(p.getCORN() + p.getItemPack().get(choose).getValue()*5/6);
            if(p.getItemPack().get(choose) instanceof Weapon ){
                inventoryW.add((Weapon) p.getItemPack().get(choose));
                System.out.println("You can always buy this weapon back at the shop.");
            }
            else if(p.getItemPack().get(choose) instanceof Armor){
                inventoryA.add((Armor) p.getItemPack().get(choose));
                System.out.println("You can always buy this armor back at the shop.");
            }
            p.getItemPack().remove(choose);
        }
    }
}
