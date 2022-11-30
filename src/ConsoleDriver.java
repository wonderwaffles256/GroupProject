import java.util.*;

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
    public void combat(Player p,Character enemy) {
        System.out.println("\u001B[31m" + enemy.getName() + " has appeared!" + "\u001B[0m");
        Scanner scnr = new Scanner(System.in);

        boolean done = false;
        while (!done) {
            //enemy says wacky funny dialogue
            //TODO: print random word from battle dialogue (separate method?)
            boolean goodinput = false;
            while (!goodinput) {
                System.out.println("Would you like to Fight( 1 ), Flirt( 2 ), Flask ( 3 ), Flee ( 4 ), or File( 5 ).\n" +
                        "Please input 1 2 3 or 4. NOTHING ELSE and hit Enter.");
                String in = scnr.nextLine();
                switch (in) {
                    case "1" -> {
                        //TODO: prompt for using companions
                        goodinput = true;
                        p.fight(enemy);
                    }
                    case "2" -> {
                        done = p.flirt(enemy,p);
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

            //TODO: have death reset health/clout instead of ending the game
            if(p.getHP() <= 0) {
                System.out.println("You tried to fight for the love of your life, but you ended up dying to " + "\u001B[31m" + enemy.getName() + "\u001B[0m");
                System.exit(0);
            }
            if(enemy.getHP() <= 0) {
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
        Weapon oneshot = new Weapon("Death Star", 10000, 500, "Kills the enemy insantly");
        Weapon Bow = new Weapon("Bow", 15, 7, "good ol trusty");


        Armor overalls = new Armor("overalls", 20, 10, "Ain't much, but it's honest work");
        Armor noArmor = new Armor("none", 0, 0, "Nothing cheaper than a birthday suit");
        Armor buisness = new Armor("suit", 100, 30, "Always the best dressed in the room");
        Armor suitOfArmor = new Armor("suit of armor", 70, 20, "looks cool, but its the 20th century");
        Armor peachDress = new Armor("princess peaches dress", 50, 25, "A pretty pink dress");
        Armor cloak = new Armor("cloak", 20, 10, "a dark cloak");


        Item rock = new Item("Charlie", 1, "A rock named Charlie");
        Item water = new Item("Kirkland Brand Water Bottle", 1, "cheap but reliable");

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
        ArrayList<Enemy> Enemies = new ArrayList<>(Arrays.asList(beet, ogre,princessPeach,pixie, robinHood));        //contains one of the enemies in order of creation
        ArrayList<Enemy> EnemiesWithWeights = new ArrayList<>();  //contains all the enemies, but has many duplicates depending on the spawn rate
        ArrayList<Enemy> forestEnemies = new ArrayList<>();
        ArrayList<Enemy> castleEnemies = new ArrayList<>();
        ArrayList<Enemy> desertEnemies = new ArrayList<>();
        Queue<ArrayList<Enemy>> locationEnemies = new LinkedList<>();

        //TODO: try to put this in a method (maybe)
        for(int i = 0; i < Enemies.size(); i++) {     //for every additional spawn rate chance is another enemy added into arraylist
            for(int z = 0; z < Enemies.get(i).getSpawnRate(); z++) {
                EnemiesWithWeights.add(Enemies.get(i));
            }
        }
        Random r = new Random();
        int loop = 0;
        if (difficulty == 1) {loop = 3;} else if (difficulty == 2) {loop = 5;} else {difficulty = 7;}


            for (int i = 0; i < loop; i++) {
                Enemies.add(EnemiesWithWeights.get(r.nextInt(EnemiesWithWeights.size() + 1)));
            }



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
        Location loc1 = new Location("Forest", difficulty, forestEnemies, loc1Msg);
        Location loc2 = new Location("Castle", difficulty, castleEnemies, loc2Msg);
        Location loc3 = new Location("Desert", difficulty, desertEnemies, loc3Msg);
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);


        location(player, locations);
    }

    //might be able to use this method for all 3 locations
    public void location (Player p, Queue<Location> locations) {
        while (locations.size() > 0) {
            Location L = locations.poll();
            ArrayList<Enemy> Enemies = new ArrayList<>(L.getLocationEnemies());

            System.out.println("Your enemies are:");        //added for testing, remove at a later date
            for (Enemy forestEnemy : Enemies) {
                System.out.println(forestEnemy.getName());
            }
            Stack<Room> rooms = L.getRooms();
            int completed = 0;
            while (!(rooms.isEmpty())) {
                Room r = rooms.pop();
                if (!r.isTreasureRoom()) {
                    Enemy e = r.getEnemy();
                    combat(p, e);
                } else {
                    // Chest c = r.getChest();  TODO: implement getChest()
                    System.out.println("chest room");
                }
                completed++;
                L.setProgress(completed);
                if (!(L.isCompleted())) {
                    System.out.println("You continue on your path, determined to survive the oncoming hordes");
                }
            }
            System.out.println("Congrats, you beat the first location!");
        }
    }

}
