import java.util.*;
//TODO companions jump in and fight randomly -done and works but should be reviewed.  method is critchance in player
//TODO make girlfriend
//TODO fix death
//TODO port console driver over to runGame
//TODO make more enemies

public class ConsoleDriver {
    public static void main(String[] args) throws InterruptedException {
        //bulk of logic elsewhere
        //should only have input-output logic
        //such as: talk to user, get user input, show changes to user

        //eg
        //create am object of type Game, Adventure...
        //Game g = new Game();
        //maybe while(g.hasWon())
        //ask user for input
        //call g.displayStatus() --- or displayBoard()

        //can add a GUI with minimal if any changes to game logic
        ConsoleDriver game = new ConsoleDriver();


        Scanner scnr = new Scanner(System.in);
        System.out.println("What difficulty would you like to play on? \n Enter 1,2 or 3 for easy, medium, or hard");
        int difficulty = scnr.nextInt();
        System.out.println("Welcome! Before you embark on your journey please enter your name");
        String name = scnr.next();
        game.start(difficulty,name);
    }
    public void tutorial(Player p, Enemy e) throws InterruptedException {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Combat here is quite simple, lets practice on this enemy!");
        Thread.sleep(1000);
        System.out.println("Before you attack, it can be a good idea to check information \n Why dont you file the enemy");
        Thread.sleep(1000);
        System.out.println("Would you like to Fight( 1 ), Flirt( 2 ), Flask ( 3 ), Flee ( 4 ), or File( 5 ).\n" +
                "hint: enter 5");
        while(!(scnr.nextInt() == 5)) {
            System.out.println("just enter 5, its that easy");
        }
        p.file(e);
        Thread.sleep(1000);
        System.out.println("Now that you know all the information, take this club and whack him");
        Thread.sleep(1000);
        System.out.println("Would you like to Fight( 1 ), Flirt( 2 ), Flask ( 3 ), Flee ( 4 ), or File( 5 ).\n" +
                "hint: enter 1");
        while(!(scnr.nextInt() == 1)) {
            System.out.println("just enter 1, its that easy");
        }
        p.fight(e);
        Thread.sleep(1000);
        e.fight(p);
        Thread.sleep(1000);
        System.out.println("Nice swing! \n now that you`ve got the hang of that, why don't you try using your flask to heal");
        Thread.sleep(1000);
        System.out.println("Would you like to Fight( 1 ), Flirt( 2 ), Flask ( 3 ), Flee ( 4 ), or File( 5 ).\n" +
                "hint: enter 3");
        while (!(scnr.nextInt() == 3)) {
            System.out.println("just enter 3, its the one in between 2 and 4");
        }
        p.flask();
        System.out.println("Healing takes up a turn just like attacking, so be careful when you do that");
        Thread.sleep(3000);
        e.fight(p);
        Thread.sleep(2000);
        System.out.println("so now is where you can make a decision \n you can either flirt with an enemy and attempt to have them join you as a companion, or you can kill them \n for practice sake, lets flirt");
        Thread.sleep(2000);
        System.out.println("Would you like to Fight( 1 ), Flirt( 2 ), Flask ( 3 ), Flee ( 4 ), or File( 5 ).\n" +
                "hint: enter 2");
        while (!(scnr.nextInt() == 2)) {
            System.out.println("its super easy i promise just press 2");
        }
        Thread.sleep(1000);
        System.out.println("Lets try the first option for flirting");
        p.flirt(e,p);
        Thread.sleep(1000);
        System.out.println("Amazing! \n that is the end of the tutorial \n Good luck traveler");
    }

    /**
     * Prints a menu to inform user and gather input
     */
    public void combat(Player p,Character enemy) throws InterruptedException{
        System.out.println("\u001B[31m" + enemy.getName() + " has appeared!" + "\u001B[0m");
        Scanner scnr = new Scanner(System.in);

        boolean done = false;
        while (!done) {
            //enemy says wacky funny dialogue
            //TODO: print random word from battle dialogue (separate method?)
            boolean goodinput = false;
            while (!goodinput) {
                System.out.println("Would you like to Fight( 1 ), Flirt( 2 ), Flask ( 3 ), Flee ( 4 ), or File( 5 ).\n" +
                        "Please input 1 2 3 4 or 5. NOTHING ELSE and hit Enter.");
                String in = scnr.nextLine();
                switch (in) {
                    case "1" -> {
                        goodinput = true;
                        p.fight(enemy);
                    }
                    case "2" -> {
                        if (enemy instanceof MiniBoss) {
                            ((MiniBoss) enemy).flirt();
                        }
                        else {
                            done = p.flirt(enemy, p);
                        }
                        goodinput = true;
                    }
                    case "3" -> {
                        p.flask();
                        goodinput = true;
                    }
                    case "4" -> {
                        p.flee();
                        goodinput = true;
                        done = true;
                    }
                    case "5" -> p.file(enemy);

                    default -> System.out.println("Please re-input");
                }
            }

            if(p.getHP() <= 0) {
                System.out.println("You tried to fight for the love of your life, but you ended up dying to " + "\u001B[31m" + enemy.getName() + "\u001B[0m");
                p.death();
                done = true;
            }
            if(enemy.getHP() <= 0) {
                if(enemy instanceof Enemy e) {
                    e.giveLoot(p);
                }
                else if(enemy instanceof Girlfriend g) {
                    g.giveMedal(p);
                }
                else if (enemy instanceof MiniBoss) {
                    ((MiniBoss) enemy).deathDialogue();
                    ((MiniBoss) enemy).giveLoot(p);
                }

                System.out.println("Combat over");
                done = true;
            }
            if (!(done)) {
                enemy.fight(p);
            }
        }
    }
    public void introDialogue() throws InterruptedException {
        System.out.println("\n \n \n \n \n \n \n \n");
        System.out.println("Your journey begins where most great journeys begin: \n a field");
        Thread.sleep(1500);
        System.out.println("You sit in silent contemplation \n after a few moments of deep thought about your life you decide that your girlfriend is the one you want to be with forever");
        Thread.sleep(1500);
        System.out.println("However, you feel not worthy of her love, so how do you get it?");
        Thread.sleep(1500);
        System.out.println("In order to assure she says yes, you decide to embark on an expedition, a journey, one to be told about for eons");
        Thread.sleep(1500);
        System.out.println("You get up and walk, walk until you feel ready");
        Thread.sleep(1000);
        System.out.println("As you walk over a hill, you can see a dense forest off in the distance.");
        Thread.sleep(1500);
        System.out.println("You travel through the forest as dark figures dart in the shadows");
    }

    public void start(int difficulty, String name) throws InterruptedException {
        //creates each basic object in the game (such as items, weapons, etc.)
        Weapon gun = new Weapon("gun", 100, 10, "It shoots stuff");
        Weapon club = new Weapon("wooden club", 10, 3, "Made of 100% tree");
        Weapon sword = new Weapon("sword", 50, 7, "A true mans weapon");
        Weapon BatWithNails = new Weapon("baseball bat with nails", 12, 4, "Perfect for surviving the zombie apocalypse");
        Weapon umbrella = new Weapon("Umbrella", 15, 6, "Im Mary Poppins y`all");
        Weapon magicWand = new Weapon("Magic Wand", 15, 6,"look this doesn't mean magic is real, i just ran out of ideas for weapons");
        Weapon laserRifle = new Weapon("Laser Rifle", 30, 8, "can shoot enemies all the way from a galaxy far far away");
        Weapon oneshot = new Weapon("Death Star", 300, 500, "Fire when ready");
        Weapon Bow = new Weapon("Bow", 15, 7, "good ol trusty");
        Weapon stick = new Weapon("A Cool Stick",150,50,"A cool stick that looks like a sword.");
        Weapon paddle = new Weapon("A paddle",10,5,"A child Abuse paddle");
        Weapon chemo = new Weapon("10-rounds of Chemotherapy",100,60,"Jesse how could you be so stupid. I am the one who Chemos.");
        Weapon heel = new Weapon("Heel", 29,35,"Worn by the meaniest of girls and swung by those even meaner" );



        Armor overalls = new Armor("overalls", 20, 10, "Ain't much, but it's honest work");
        Armor noArmor = new Armor("none", 0, 0, "Nothing cheaper than a birthday suit");
        Armor buisness = new Armor("suit", 100, 30, "Always the best dressed in the room");
        Armor suitOfArmor = new Armor("suit of armor", 70, 20, "looks cool, but its the 20th century");
        Armor peachDress = new Armor("princess peaches dress", 50, 25, "A pretty pink dress");
        Armor cloak = new Armor("cloak", 20, 10, "a dark cloak");
        Armor hat = new Armor("Pork Pie Hat",25,7,"A familiar hat that smells like a meth lab");

        Consumable water = new Consumable("Nestle Spring Water", 2, 5, "Capitalism's finest");
        Consumable tiny = new Consumable("Bud Lite", 5,10,"Choice beer for the middle class diabetic. Restores a small bit of health");
        Consumable small = new Consumable("Bud Heavy", 10, 25, "Originally recalled due to health concerns, the Bud Heavy's claim to fame is it's use of condensed leaded gasoline, offering over twice the potency of a standard Bud Lite");
        Consumable medium = new Consumable("Moonshine",20,50,"Strong liquor, straight from the Prohibition");
        Consumable large = new Consumable("Vodka",50,110,"The label is in indecipherable Russian, but a warning symbol on the back depicts a drunken bear");
        Item rock = new Item("Charlie", 1, "A rock named Charlie");

        ArrayList<Item> allItems = new ArrayList<>(Arrays.asList(water,tiny,small,medium,large,rock,overalls,buisness,suitOfArmor,peachDress,cloak,gun,club,sword,BatWithNails,umbrella,magicWand,laserRifle,oneshot,Bow,stick,paddle));
        Chest c = new Chest(allItems);
        ArrayList<Item> beetLoot = new ArrayList<>();
        ArrayList<String> beetBattleDialogue = new ArrayList<>();
        ArrayList<String> beetFlirtDialogue = new ArrayList<>();
        beetLoot.add(rock);
        beetBattleDialogue.add("I will BEET you");

        //this is the resulting string from the correct flirt option (placed in the constructor as its flirt requirement)
        String beetSuccess = "Thanks, I've been trying to lose weight recently. You're the first person to notice.\n*He smiles bashfully*";
        //Index 0 contains ONE string with all options for flirting
        beetFlirtDialogue.add("1 - Compliment his physique\n" + "2 - Stare into his beety eyes\n" + "3 - Playfully insult his mother");
        //Indexes 1-3 contain the results from options 1, 2, and 3
        beetFlirtDialogue.add(beetSuccess);     //correct option
        beetFlirtDialogue.add("Oh... uhhh, I can be intense too.\n*Baljbeet stares through your soul*");    //string for an incorrect option
        beetFlirtDialogue.add("that's not very nice of you");                                         //string for an incorrect option
        Enemy beet = new Enemy(12, "Baljbeet", noArmor, club, 5, beetLoot, beetSuccess, 8, beetBattleDialogue, beetFlirtDialogue);
        //

        String ogreSuccess = "Grunts happily";
        ArrayList<Item> ogreLoot = new ArrayList<>();
        ArrayList<String> ogreBattleDialogue = new ArrayList<>();
        ogreBattleDialogue.add("Grunts angrily");
        ArrayList<String> ogreFlirtDialogue = new ArrayList<>();
        ogreFlirtDialogue.add("1 - Assert dominance by grunting louder \n" + "2 - Hand him a flower \n" + "3 - Smack the ground to make a loud noise");
        ogreFlirtDialogue.add("Grunts louder then before and somehow looks angrier and uglier");
        ogreFlirtDialogue.add(ogreSuccess);
        ogreFlirtDialogue.add("Laughs at you and then returns to his angry ogre face");
        Enemy ogre = new Enemy(12, "Ogre", overalls, BatWithNails, 7, ogreLoot, ogreSuccess, 7, ogreBattleDialogue, ogreFlirtDialogue);

        String peachSuccess = "Mario's never around anymore, I guess this could be fun";
        ArrayList<Item> peachLoot = new ArrayList<>();
        ArrayList<String> peachBattleDialogue = new ArrayList<>();
        peachBattleDialogue.add("You're nothing compared to what ive gone up against");
        ArrayList<String> peachFlirtDialogue = new ArrayList<>();
        peachFlirtDialogue.add("1 - Sing the Rainbow Road theme \n" + "2 - *Mario impression* \n" + "3 - Flex your cash");
        peachFlirtDialogue.add("You'll be hearing from the Nintendo lawyers");
        peachFlirtDialogue.add(peachSuccess);
        peachFlirtDialogue.add("broke...");
       Enemy princessPeach = new Enemy(25, "Princess Peach", peachDress, umbrella, 10, peachLoot, peachSuccess, 2, peachBattleDialogue, peachFlirtDialogue);

        String pSuccess = "*Chimes happily and flies close to you*";
        ArrayList<Item> pLoot = new ArrayList<>();
        ArrayList<String> pBattleDialogue = new ArrayList<>();
        pBattleDialogue.add("*Threatening orb of light approaches*");
        ArrayList<String> pFlirtDialogue = new ArrayList<>();
        pFlirtDialogue.add("1 -  Joke about burning down the forest \n" + "2 - compliment its radiance \n" + "3 - admire the beauty of nature");
        pFlirtDialogue.add("*flies around looking even angrier*");
        pFlirtDialogue.add("*continues shining brilliantly*");
        pFlirtDialogue.add(pSuccess);
        Enemy pixie = new Enemy (15, "Pixie", noArmor,magicWand , 8, pLoot,pSuccess,6,pBattleDialogue,pFlirtDialogue);

        String panSuccess = "YES! together we shall vanquish the rising wage gap and distribute the wealth through by breaking the law";
        ArrayList<Item> panLoot = new ArrayList<>();
        ArrayList<String> panBattleDialogue = new ArrayList<>();
        panBattleDialogue.add("Who dares challenge the protector of the poor");
        ArrayList<String> panFlirtDialogue = new ArrayList<>();
        panFlirtDialogue.add("1 - describe your hate for the wealthy and love for the poor \n" + "2 - Talk about how much money you have \n" + "3 - compliment his bow");
        panFlirtDialogue.add(panSuccess);
        panFlirtDialogue.add("Then you not only deserve not your life, but neither your money");
        panFlirtDialogue.add("It'll be the last thing you see");
        Enemy robinHood = new Enemy(30, "Robin Hood", noArmor, Bow, 4, panLoot, panSuccess, 5, panBattleDialogue, panFlirtDialogue);


//        Enemy grunt = new Enemy(15, "grunt", overalls, club, 6, gruntLoot, gruntSuccess, 7, gruntBattleDialogue, gruntFlirtDialogue);
//        Enemy jBourne = new Enemy(35, "Jason Bourne", noArmor, gun, 7, bourneLoot, bourneSuccess, 5, bourneBattleDialogue, bournFlirtDialogue);
//        Enemy Bond = new Enemy(30, "007", buisness, gun, 2, bondLoot, bondSuccess, 4, bondBattleDialogue, bondFlirtDialogue);
//        Enemy TuskenRaider = new Enemy(13, "Tusken Raider", overalls, laserRifle, 8, trLoot, trSuccess, 4, trBattleDialogue, trFlirtDesign);
//        Enemy Jawa = new Enemy(20, "Jawa", cloak, laserRifle, 3, jawaLoot, jawaSuccess, 4, jawaBattleDialogue, jawaFlirtDesign);
//        Enemy KingArthur = new Enemy(40, "King Arthur", suitOfArmor, sword, 7, arthurLoot, arthurSuccess,5, arthurBattleDialogue, arthurFlirtDialogue);
//
//        Enemy yurMum =
        String NyeSuccess = "With our combined power we shall end global warming and make the whole world lukewarm!";
        ArrayList<Item> NyeLoot = new ArrayList<>();
        ArrayList<String> NyeBattleDialogue = new ArrayList<>();
        NyeBattleDialogue.add("It just doesn't make any sense as to why you would challenge me, an academic unit.");
        ArrayList<String> NyeFlirtDialogue = new ArrayList<>();
        NyeFlirtDialogue.add("1 - describe your intense plan to end Global warming \n" + "2 - Sing his Theme Song \n" + "3 - Tell him that he taught you science in 5th grade");
        NyeFlirtDialogue.add(NyeSuccess);
        NyeFlirtDialogue.add("That song really annoyed me and so do you");
        NyeFlirtDialogue.add("Obviously you never paid enough attention during that class so I'll teach you what it's like to lose");
        Enemy BillNye = new Enemy(20,"Bill Nye",buisness,laserRifle,6,NyeLoot,NyeSuccess,5,NyeBattleDialogue,NyeFlirtDialogue);

        String WaltSuccess = "Maybe now I can go make Jr. some breakfast";
        ArrayList<Item> WaltLoot = new ArrayList<>();
        ArrayList<String> WaltBattleDialogue = new ArrayList<>();
        WaltBattleDialogue.add("Say my name.");
        ArrayList<String> WaltFlirtDialogue = new ArrayList<>();
        WaltFlirtDialogue.add("1 - Cure his cancer \n" + "2 - Give him some Methylamine \n" + "3 - Knock on his door");
        WaltFlirtDialogue.add(WaltSuccess);
        WaltFlirtDialogue.add("How could you be so stupid to give me this out in the open. Apply Yourself.");
        WaltFlirtDialogue.add("I am the one who knocks!");
        Enemy BreakBad = new Enemy(10,"Walter White",hat,chemo,5,WaltLoot,WaltSuccess,3,WaltBattleDialogue,WaltFlirtDialogue);


        ArrayList<Enemy> Enemies = new ArrayList<>(Arrays.asList(beet, ogre,princessPeach,pixie, robinHood,BillNye,BreakBad));        //contains one of the enemies in order of creation

        ArrayList<Item> itemPack = new ArrayList<>();
        ArrayList<Character> companions = new ArrayList<>();
        itemPack.add(water);
        Player player = new Player(100, name, overalls, oneshot, 10);

        //tutorial
        System.out.println("Would you like to play the tutorial and read the intro dialogue? \n press 1 for yes and 2 for no");
        Scanner scnr = new Scanner(System.in);
        if (scnr.nextInt() == 1) {
            tutorial(player, beet);
            introDialogue();
        }
        else {
            System.out.println("Very well, good luck on your adventures traveler");
        }
        String loc1Msg = "You enter what seems to be a forest. Huge, weeping trees tower above.";
        String loc2Msg = "You come across a magnificent castle. It must've stood here for centuries. You enter warily.";
        String loc3Msg = "You enter a desert. It's dry.";
        Queue<Location> locations = new LinkedList<>();

        ArrayList<Item> reginaLoot = new ArrayList<>();
        reginaLoot.add(peachDress);
        reginaLoot.add(heel);
        String reginaFlirt = "And right now, your getting on my last nerve! Switch";
        String reginaBattle = "Im not like a regular mom.  Im a cool mom";
        String reginaDeath = "Im going to forgive you because im a very Zen person.  And im on a lot of pain medication right now";
        String reginaIntro = "Get in loser.  We`re going shopping";
        MiniBoss reginaGeorge = new MiniBoss(75,"Regina George", peachDress,heel,4,reginaLoot,reginaFlirt,reginaIntro,reginaBattle,reginaDeath);

        ArrayList<Item> karenLoot = new ArrayList<>();
        karenLoot.add(peachDress);
        karenLoot.add(heel);
        String karenFlirt = "Why are you dressed so scary?";
        String karenBattle = "Well... Im kinda psychic.  I have a fifth sense.";
        String karenDeath = "So that's against the rules, and you cant sit with us";
        String karenIntro = "On Wednesdays we wear pink";
        MiniBoss karen = new MiniBoss(90,"Karen Smith", peachDress,heel,6,karenLoot,karenFlirt,karenIntro,karenBattle,karenDeath);

        ArrayList<Item> gretchenLoot = new ArrayList<>();
        gretchenLoot.add(peachDress);
        gretchenLoot.add(heel);
        String gretchenFlirt = "Im sorry that people are so jealous of me.  But i can`t help it that im popular";
        String gretchenBattle = "thats so fetch";
        String gretchenDeath = "Oh no, I cant say anything else until i have a parent or lawyer present";
        String gretchenIntro = "you can only wear your hair in a ponytail once a week, so i guess you chose today";
        MiniBoss gretchen = new MiniBoss(100,"Gretchen Weiners", peachDress,heel,8,gretchenLoot,gretchenFlirt,gretchenIntro,gretchenBattle,gretchenDeath);

        Location loc1 = new Location("Forest", difficulty, randomizeEnemies(Enemies), loc1Msg,reginaGeorge);
        Location loc2 = new Location("Castle", difficulty, randomizeEnemies(Enemies), loc2Msg,karen);
        Location loc3 = new Location("Desert", difficulty, randomizeEnemies(Enemies), loc3Msg,gretchen);
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        Shop s = new Shop(allItems);
        Queue<MiniBoss> miniBosses= new LinkedList();
        miniBosses.add(reginaGeorge);
        miniBosses.add(karen);
        miniBosses.add(karen);

        while  (locations.size() > 0) {
            location(player, locations.peek());
            miniBossFight(player,miniBosses.poll(),locations.poll());
            s.shopMenu(player);
        }

    }
    public void miniBossFight(Player p, MiniBoss B, Location L) throws InterruptedException {
        B.introFight(p);
        combat(p,B);
        System.out.println("Congrats! you have completed the " + L.getName() + " location");
    }

    //might be able to use this method for all 3 locations
    public void location (Player p, Location L) throws InterruptedException{
        System.out.println("New location: " + L);
            Stack<Room> rooms = L.getRooms();
            int completed = 0;
            while (!(rooms.isEmpty())) {
                Room r = rooms.pop();
                if (!r.isTreasureRoom()) {
                    Enemy e = r.getEnemy();
                    combat(p, e);
                } else  {
                     Item I = r.getChest();
                     chestRoom(I,p);
                }
                completed++;
                L.setProgress(completed);
                if (!(L.isCompleted())) {
                    System.out.println("You continue on your path, determined to survive the oncoming hordes");
                }
            }
        }

    public ArrayList<Enemy> randomizeEnemies(ArrayList<Enemy> Enemies) {
        ArrayList<Enemy> EnemiesWithWeights = new ArrayList<>();  //contains all the enemies, but has many duplicates depending on the spawn rate
        for(int i =0; i < Enemies.size(); i++) {     //for every additional spawn rate chance is another enemy added into arraylist
            for (int z = 0; z < Enemies.get(i).getSpawnRate(); z++) {
                EnemiesWithWeights.add(Enemies.get(i));
            }
        }
        Enemies.clear();
        Random r = new Random();
        for (int i = 0; i < 7; i++) {
            Enemy e = new Enemy(EnemiesWithWeights.get(r.nextInt(EnemiesWithWeights.size())));
            Enemies.add(e);
        }
        return Enemies;
    }

    public void chestRoom(Item i, Player p) {
        Scanner scnr = new Scanner(System.in);
        boolean loop = false;
        System.out.println("\u001B[35m" + "You come across an old chest");
        if (i instanceof Weapon) {
            System.out.println("Inside the chest is a weapon \n You inspect the weapon: " + "\u001B[0m" );
            System.out.println(i.getName() + " does " + ((Weapon) i).getDamage() + " damage \n its inscription reads: "  + i.getDescription());
            System.out.println("your current weapon does " + p.getWeapon().getDamage());
            System.out.println("Would you like to equip this item? \n 1 for yes, and 2 for no");
            p.addItemPack(i);
            while (!loop) {
                if (scnr.nextInt() == 1) {
                    p.equipWeapon((Weapon) i);
                    loop = true;
                    System.out.println("You continue on your path");
                }
                else if (scnr.nextInt() == 2) {
                    loop = true;
                    System.out.println("You continue on your path");
                }
            }
        }
        else if (i instanceof Consumable) {
            System.out.println("Inside the chest is a drink \n You inspect the drink"+ "\u001B[0m");
            System.out.println(i.getName() + " heals for " + ((Consumable) i).getHealing() + "\n its inscription reads: " + i.getDescription() + "\n you place the item in your flask" + "\u001B[0m");
            p.addItemPack(i);

        }
        else if (i instanceof Armor) {
            System.out.println("Inside the chest is some clothes \n You inspect the clothes" + "\u001B[0m");
            System.out.println(i.getName() + " has an armor rating of " + ((Armor) i).getStrength() + "\n its inscription reads: " + i.getDescription());
            System.out.println("your current armor, " + p.getArmor().getName() + ", has a rating of " + p.getArmor().getStrength());
            System.out.println("Would you like to equip this Armor? \n 1 for yes, and 2 for no");
            p.addItemPack(i);
            while (!loop) {
                int ans = scnr.nextInt();
                if (ans == 1) {
                    p.equipArmor((Armor) i);
                    loop = true;
                    System.out.println("You continue on your path");
                }
                else if (ans == 2) {
                    loop = true;
                    System.out.println("You continue on your path");
                }
            }
        }

        else {
            System.out.println("Inside the chest is a item \n You inspect the item" + "\u001B[0m");
            System.out.println(i.getName() + "it is worth" + i.getValue() + "\n its inscription reads: " + i.getDescription() + "\n you place the item in your pack");
            p.addItemPack(i);
        }
    }

}
