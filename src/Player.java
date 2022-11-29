import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Character{
    private double clout;                   //clout will start at 0
    private int CORN;                       //CORN will start at 0
    private ArrayList<Item> itemPack;
    private ArrayList<Character> companions;
    private int maxHP;
    private String currentLocation;
    boolean locComplete;

    /**
     * default constructor
     * initializes the player object with no parameters
     */
    public Player() {
        super();
        clout = 1;
        CORN = 0;
        itemPack = new ArrayList<>();
        companions = new ArrayList<>();
        locComplete = false;
    }

    /**
     *
     * @param HP health of player
     * @param name name of player
     * @param armor armor rating of player
     * @param weapon weapon held by player
     * @param critChance chance of landing critical hit
     * @param itemPack arraylist of items the player has
     * @param companions arraylist of all the companions the player has
     */

    //constructor given input
    public Player(int HP, String name, Armor armor, Weapon weapon, double critChance, ArrayList<Item> itemPack, ArrayList<Character> companions) {
        super(HP + armor.getStrength(), name, armor, weapon, critChance);
        clout = 1;
        CORN = 0;
        maxHP = HP + armor.getStrength();
        locComplete = false;
        this.itemPack = new ArrayList<>();
        this.companions = new ArrayList<>();

        this.itemPack.addAll(itemPack);
        this.companions.addAll(companions);
    }

    /**
     * getter
     * @return clout
     */
    //getters
    public double getClout() {return clout;}
    public int getCORN() {return CORN;}
    public int getMaxHP() {return maxHP;}
    public String getCurrentLocation() {return currentLocation;}
    public boolean getLocComplete() {return locComplete;}
    public ArrayList<Item> getItemPack() {return itemPack;}
    public ArrayList<Character> getCompanions() {return companions;}

    //setters
    public void setCORN(int CORN) {this.CORN = CORN;}
    public void setClout(double clout) {this.clout = clout;}
    public void setCurrentLocation(String currLoc) {this.currentLocation = currLoc;}
    public void setLocComplete(boolean complete) {this.locComplete = complete;}

    /**
     * when user obtains corn it sums the newly obtained bits with the existing amount
     * @param corn adds new corn onto existing
     */
    public void acquireCorn(int corn){CORN = corn + CORN;}

    /**
     * Player's version of the fight method. Multiplies damage by their current clout modifier.
     * @param opponent - the Character being fought
     */
    //TODO: implement companion option
    //TODO: implement way to get loot from an enemy
    public void fight(Character opponent){
        double dmg = ((double) this.getWeapon().getDamage()) * clout;
        opponent.setHP((int) Math.round((double) opponent.getHP() - dmg));
        System.out.println("\u001B[36m" + "Using your " + this.weapon.getName() + " you hit " + opponent.getName() + " for " + Math.round(dmg) + " damage!" + "\u001B[0m");
        if(opponent.getHP() <= 0) {
            System.out.println("\u001B[36" + "You have vanquished " + "\u001B[31m" + opponent.getName() + "\u001B[0m");
        }
    }

    /**
     * player flees combat
     * this act of cowardice decreases their clout
     */
    public void flee() {
        this.clout -= this.clout - 0.2;
        System.out.println("How can you expect to impress a girl if you cannot impress yourself?.\n" +
                           "CLOUT reduced by 0.2!");
    }

    /**
     * player flirts with enemy
     * if successful then enemy becomes a companion
     */
    public boolean flirt(Character c, Player p) {
        Scanner sc = new Scanner(System.in);

        boolean done = false;
        while(!done) {
            try {
                if(c instanceof Enemy e) {
                    done = true;
                    System.out.println("\u001B[36m" + "You advance upon " + "\u001B[31m" + e.getName() + "\u001B[36m" + ", it looks startled.\n" +
                            "Do you:\n" + "\u001B[33m");
                    System.out.println(e.getFlirtDialogue().get(0));      //prints opening options for flirting
                    int choice = sc.nextInt();

                    if(flirtCheck(choice,e)) {
                        if (!(e.getName().equals("Baljbeet"))) {                    //adds enemy to companions
                            companions.add(e);
                        }

                        System.out.println(e.getFlirtDialogue().get(choice));       //prints line resulting from correct option
                        System.out.println("\u001B[33m" + e.getName() + " has joined the team!" + "\u001B[0m");
                        e.setHP(0);
                        return true;
                    }
                    else {
                        System.out.println("\u001B[31m"  +  e.getFlirtDialogue().get(choice) + "\u001B[0m");
                        System.out.println("\u001B[36m" + "Your advances do not impress the enemy." + "\u001B[0m");
                    }

                }//end enemy check
                else if (c instanceof Girlfriend g) {
                    if(g.getFlirtLimit() < 3) {
                    System.out.println("You attempt to flirt with your girlfriend.");
                    StringBuilder choices = new StringBuilder();                        //holds each choice made by the player in sequence

                    for (String options : g.getFlirtOptions()) {         //iterates through each set of options (numbered 1->n)
                        System.out.println("""
                                Please enter the number of your desired option.
                                    If you want to bail out, enter 0.
                                                                
                                Do you:\s
                                """);
                        System.out.println(options);
                        int choice = sc.nextInt();

                        choices.append(choice);
                        if (choice <= 0) {                              //allows player to exit the flirt
                            System.out.println("Coward");
                            break;
                        }

                        System.out.println(g.getFlirtResponses().get(choice) + "\n");     //prints a response based on the player's choice from the flirtResponse list
                    }
                    if (choices.toString().equals(g.getFlirtSuccess())) {      //checks if the player has chosen the correct sequence options using the string builder (choices)
                        System.out.println(g.getFlirtResponses().get(0));      //index 0 of flirtResponses holds dialogue for a successful flirt
                        Thread.sleep(1000);
                        System.out.println(g.getName() + " is so impressed by your groveling that she begins to foster a kernel of respect for you.");

                        p.setClout(p.getClout() + (g.getDifficulty() - 0.5));               //adds lots of clout based on difficulty
                        System.out.println("Your clout increased substantially");
                        g.setFlirtLimit(3);                                                 //ensures any future flirts cannot be attempted

                    } else {
                        System.out.println("Your feeble fumbling at flattery falls flat on its face");
                        Thread.sleep(1000);
                        g.setFlirtLimit(g.getFlirtLimit() + 1);                 //increases flirt limit
                    }//end success checker
                }
                else{System.out.println(g.getName() + " seems reluctant to converse further");}//end flirt limit checker
                }//end girlfriend case

            }//end try block
            catch(Exception E) {
                System.out.println("You must be a monkey. Please enter a number");
            }
        }//end while loop

        return false;                        //returns a boolean for the combat method to decide whether it needs to end
    }

    //checks if a chosen option during flirting equals the enemy's flirt requirement
    public boolean flirtCheck(int option, Enemy e) {
        return e.getFlirtDialogue().get(option).equals(e.getFlirtRequirement());
    }

    /**
     * player uses items from his itemPack to heal hp or gain some other buff
     */
    public void flask() {
        Scanner sc = new Scanner(System.in);
        if(this.itemPack.isEmpty()) {
            System.out.println("You ain't got nothin boy!\n" + "Go get some junk!");
        }
        else{
            try{
                displayItems();
                System.out.println("Please enter the number for the item you would like to use");
                int choice = sc.nextInt();

                System.out.println("\u001B[36m" + "You used " + this.itemPack.get(choice).getName() );
                itemPack.remove(this.itemPack.get(choice));

                //TODO: add checker to determine different actions based on item type (equip weapon/armor, heal)
                //This needs to be implemented through a consumable class (if time allows)
                System.out.println("You recovered " + healRemainder(maxHP/3) + " HP" + "\u001B[0m");

                if(HP + maxHP/3 < maxHP) {
                    this.setHP(this.getHP() + maxHP / 3);
                    this.itemPack.remove(choice);
                }
                else{
                    this.setHP(maxHP);
                }
            }
            catch(Exception e) {
                System.out.println("You nincompoop. Enter a number next time.");
            }

        }//end else
    }

    public int healRemainder(int healedAmt) {
        if(HP + healedAmt > maxHP) {
            int overflow  = (HP + healedAmt) - maxHP;
            return healedAmt - overflow;
        }
        else {return healedAmt;}
    }

    public void displayItems() {
        for(int i = 0; i < this.itemPack.size(); i++) {
            System.out.println("Item " + i + ": " + this.itemPack.get(i).getName());
        }
    }

    /**
     * allows the user to equip a weapon of their choice
     */
    public void equipWeapon() {}//implement later

    /**
     * allows player to choose one of a companions to fight for them once during a battle
     */
    //TODO: make companions functional
    public void useCompanions() {}//implement after flirting


    /**
     * displays information about the current enemy and player
     * @param opp - enemy player is fighting
     */
    public void file(Character opp){
        System.out.println("\u001B[36m" + name + " has " + HP + " HP and can thawck for " + this.weapon.getDamage() + " Damage." + "\u001B[0m");
        System.out.println( "\u001B[31m" + opp.getName() + " has " + opp.getHP() + "left. Hope you can overcome that" + "\u001B[0m");
    }

}