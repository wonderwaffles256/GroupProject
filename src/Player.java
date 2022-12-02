import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Player extends Character{
    private double clout;                   //clout will start at 0
    private int CORN;                       //CORN will start at 0
    private ArrayList<Item> itemPack;
    private ArrayList<Character> companions;
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
     */

    //constructor given input
    public Player(int HP, String name, Armor armor, Weapon weapon, double critChance) {
        super(HP, name, armor, weapon, critChance);
        clout = 1;
        CORN = 0;

        locComplete = false;
        this.itemPack = new ArrayList<>();
        this.companions = new ArrayList<>();

        //this.itemPack.addAll(Arrays.asList(weapon, armor));
        for(int i=0; i<3; i++) {this.itemPack.add(new Consumable("Bottled Water", 2, 15, "Capitalism's finest"));}
    }

    /**
     * getter
     * @return clout
     */
    //getters
    public double getClout() {return clout;}
    public int getCORN() {return CORN;}
    public String getCurrentLocation() {return currentLocation;}
    public boolean getLocComplete() {return locComplete;}
    public ArrayList<Item> getItemPack() {return itemPack;}
    public ArrayList<Character> getCompanions() {return companions;}

    //setters
    public void setCORN(int CORN) {this.CORN = CORN;}
    public void setClout(double clout) {this.clout = clout;}
    public void setCurrentLocation(String currLoc) {this.currentLocation = currLoc;}
    public void setLocComplete(boolean complete) {this.locComplete = complete;}
    public void addItemPack(Item i) {itemPack.add(i);}

    /**
     * when user obtains corn it sums the newly obtained bits with the existing amount
     * @param corn adds new corn onto existing
     */
    public void acquireCorn(int corn){CORN = corn + CORN;}

    /**
     * Player's version of the fight method. Multiplies damage by their current clout modifier.
     * @param opponent - the Character being fought
     */

    public void fight(Character opponent){
        boolean usedCompanion = false;
        if(companions.size() > 0) {
            usedCompanion = useCompanions(opponent);
        }
        if(!usedCompanion){
            double dmg = ((double) this.getWeapon().getDamage()) * clout;
            opponent.setHP((int) Math.round((double) opponent.getHP() - dmg));
            System.out.println("\u001B[36m" + "Using your " + this.weapon.getName() + " you hit " + opponent.getName() + " for " + Math.round(dmg) + " damage!" + "\u001B[0m");

        }
        if(opponent.getHP() <= 0) {
            System.out.println("\u001B[36m" + "You have vanquished " + "\u001B[31m" + opponent.getName() + "\u001B[0m");
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
                    System.out.println("\u001B[36m" + "You advance upon " + "\u001B[31m" + e.getName() + "\u001B[36m" + ", it looks startled.\n" +
                            "Do you:\n" + "\u001B[33m");
                    System.out.println(e.getFlirtDialogue().get(0));      //prints opening options for flirting
                    int choice = sc.nextInt();
                    done = true;

                    if(flirtCheck(choice,e) && !companions.contains(e)) {
                        companions.add(e);                                          //adds enemy to companions

                        System.out.println(e.getFlirtDialogue().get(choice));       //prints line resulting from correct option
                        System.out.println("\u001B[33m" + e.getName() + " has joined the team!" + "\u001B[0m");
                        e.setHP(0);
                        return true;
                    }
                    else if(companions.contains(e)) {
                        System.out.println(e.getName() + " sees that you're already in a serious relationship. It turns it's nose in jealousy.");
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
                        sc.nextLine();

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
                        Thread.sleep(1000);
                        System.out.println("Your clout increased substantially");
                        g.setFlirtLimit(3);                                                 //ensures any future flirts cannot be attempted

                    } else {
                        System.out.println("Your feeble fumbling at flattery falls flat on its face");
                        Thread.sleep(1000);
                        g.setFlirtLimit(g.getFlirtLimit() + 1);                 //increases flirt limit
                    }//end success checker
                        done = true;
                }
                else{System.out.println(g.getName() + " seems reluctant to converse further"); done = true;}//end flirt limit checker
                }//end girlfriend case

            }//end try block
            catch(Exception E) {
                System.out.println("You must be a monkey. Please enter a number\n");
                sc.nextLine();
            }
        }//end while loop

        return false;                        //returns a boolean for the combat method to decide whether it needs to end
    }

    //checks if a chosen option during flirting equals the enemy's flirt requirement
    public boolean flirtCheck(int option, Enemy e) {
        return e.getFlirtDialogue().get(option).equals(e.getFlirtRequirement());
    }

    /**
     * Allows player to equip items or use consumables from their item pack
     */
    public void flask() {
        Scanner sc = new Scanner(System.in);
        if(this.itemPack.isEmpty()) {
            System.out.println("You ain't got nothin boy!\n" + "Go get some junk!");
        }
        else{
            boolean done = false;
            while(!done) {
                try{
                    displayItems();
                    System.out.println("Please enter a number for the item you would like to use. (-1 or less to exit, ending your turn)");
                    int choice = sc.nextInt();

                    if(choice < 0) {
                        break;
                    }
                    Item chosenItem = this.itemPack.get(choice);            //obtains item chosen by the player, then carries out an action based on its type
                    if(chosenItem instanceof Weapon w) {
                        System.out.println("Would you like to equip " + w.getName() + "?\n  (y for yes, anything else for no)");
                        String ch = sc.next();
                        if(ch.equals("y") || ch.equals("Y")) {
                            equipWeapon(w);
                            done = true;
                        }
                    }
                    else if(chosenItem instanceof Armor a) {
                        System.out.println("Would you like to equip " + a.getName() + "?\n  (y for yes, anything else for no)");
                        String ch = sc.next();
                        if(ch.equals("y") || ch.equals("Y")) {
                            equipArmor(a);
                            done = true;
                        }
                    }
                    else if(chosenItem instanceof Consumable c) {
                        System.out.println("Would you like to use " + c.getName() + "?\n  (y for yes, anything else for no)");
                        String ch = sc.next();
                        if(ch.equals("y") || ch.equals("Y")) {
                            useConsumable(c,choice);
                            done = true;
                        }
                    }
                    else {
                        System.out.println("This item is mostly useless, best to be sold or kept as a keepsake");
                    }
                }
                catch(Exception e) {
                    System.out.println("You nincompoop. Enter a good number next time.");
                    sc.nextLine();
                }
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
        System.out.println("Equipped Weapon: " + this.weapon.getName() + " ______________ " + this.weapon.getDescription());
        System.out.println("Equipped Armor: " + this.armor.getName() + " ______________ " + this.armor.getDescription());
        for(int i = 0; i < this.itemPack.size(); i++) {
            System.out.println("\u001B[32mItem " + i + ": " + this.itemPack.get(i).getName() + " _____________  " + this.itemPack.get(i).getDescription() +"\u001B[0m");
        }
    }

    public void displayCompanions() {
        for(int i = 0; i < this.companions.size(); i++) {
            Character companion = this.companions.get(i);
            System.out.println("\u001B[34mCompanion " + i + ": " + companion.getName()  + " ___ Weapon: " + companion.getWeapon().getName() + " - " + companion.getWeapon().getDamage() + " dmg\u001B[0m");
        }
    }

    public void equipWeapon(Weapon w) {
        if(!itemPack.contains(w)) {
            itemPack.add(w);
        }
        this.itemPack.add(this.weapon);
        this.itemPack.remove(w);
        this.weapon = new Weapon(w);
        System.out.println("You equipped: " + w.getName() + "\nDamage: " + w.getDamage());
    }

    public void equipArmor(Armor newArmor) {
        if(!itemPack.contains(newArmor)) {
            itemPack.add(newArmor);
        }
        this.itemPack.add(this.armor);
        this.itemPack.remove(newArmor);
        this.maxHP += newArmor.getStrength() - armor.getStrength();
        this.armor = new Armor(newArmor);
        if(HP > maxHP) {HP = maxHP;}
        System.out.println("You equipped: " + newArmor.getName() + "\nStrength: " + newArmor.getStrength());
    }

    public void useConsumable(Consumable c, int index) {
        int remainder = healRemainder(c.getHealing());
        HP += remainder;
        itemPack.remove(this.itemPack.get(index));
        System.out.println("You used " + c.getName() + ", recovering " + remainder + " HP");
    }

    public void death() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Continue Adventuring? (y for yes, anything else for no)");
        String ch = sc.next();
        if(ch.equals("y") || ch.equals("Y")) {
            Thread.sleep(1500);
            System.out.println("As you begin to black out, you hear the faint voices of your companions slowly growing quieter. It seems they decided to leave for good.");
            HP = maxHP;
            clout = 1;
            CORN = 0;
            companions.clear();
            Thread.sleep(1500);
            System.out.println("You awaken at the foot of a tree. Your wounds seem to have healed, but at the cost of your friends.");
            Thread.sleep(1500);
            System.out.println("You reach into your pockets. Whatever money you had has vanished.");
        }
        else {
            Thread.sleep(1500);
            System.out.println("Game Over");
            Thread.sleep(1500);
            System.out.println("---------------------Farmer's Only Quest------------------------");
            Thread.sleep(1500);
            System.out.println("Programmers, Writers, Designers, and Masters of the Universe:\n");
            Thread.sleep(1500);
            System.out.println("                      Daniel Newcomb");
            Thread.sleep(1500);
            System.out.println("                      Sean Malencia");
            Thread.sleep(1500);
            System.out.println("                      Owen Schulze");
            Thread.sleep(1500);
            System.out.println("                      Noah Adams");
            Thread.sleep(1500);
            System.out.println("                   Thanks for playing!");
            System.exit(0);
        }
    }

    public void giveCORN(Random chance) {
        //gives random corn
        int newCORN = chance.nextInt(10,25);
        this.CORN += newCORN;
        System.out.println("You find a shiny stash of " + newCORN + " CORN sticking out of its pocket");
    }
    public void giveCORN() {
        Random r = new Random();
        this.CORN += r.nextInt(25,50);
    }

    /**
     * allows player to choose one of a companions to fight for them once during a battle
     */
    public boolean useCompanions(Character opponent){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to use one of your companions instead? \n(y for yes, anything else for no)\n");
        String ch = sc.next();
        if(ch.equals("y") || ch.equals("Y")) {
            boolean done = false;
            while(!done) {
                try{
                    System.out.println("Please select which companion you would like to use\n(enter -1 or less to return to a regular fight)");
                    displayCompanions();
                    int choice = sc.nextInt();
                    if(choice >= 0) {
                        done = true;
                        Enemy companion = (Enemy) this.companions.get(choice);
                        if(!companion.getTired()) {
                            companion.fight(opponent);
                            companion.setTired(true);
                            System.out.println(companion.getName() + " seems tired from battle.");
                            return true;
                        }
                        else{
                            System.out.println(companion.getName() + " is to tired to fight.\n");
                            Thread.sleep(1000);
                        }//end companion fight
                    }
                    else {
                        System.out.println("After taking a good look at your cast of companions, you decide their strength simply cannot match your own.\n");
                        Thread.sleep(1000);
                        done = true;
                    }//end companion selection

                }//end try block
                catch (Exception e) {
                    System.out.println("Did you barf all over the keyboard? Because I don't see any numbers.\nTry Again\n");
                    sc.nextLine();
                }
            }//end companion menu

        }//end companion prompt
        else {System.out.println("Your confidence is inspiring\n");}
        return false;
    }


    /**
     * displays information about the current enemy and player
     * @param opp - enemy player is fighting
     */
    public void file(Character opp){
        System.out.println("\u001B[34m" + name + " has " + HP + " HP, wielding a " + this.weapon.getName() + "\n" +
                opp.getName() + " has " + opp.getHP() + " left. Hope you can overcome that\n"
                + "Current Companions: \u001B[0m");
        if(companions.size() > 0) {
            displayCompanions();
        }
        else {
            System.out.println("\u001B[34m  None\n\u001B[0m");
        }
    }
}