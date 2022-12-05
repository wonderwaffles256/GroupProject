import javax.swing.*;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class game {
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
        boolean gameOver = false;
        if(!(enemy instanceof MiniBoss)) {
            Thread.sleep(1500);
            System.out.println("\u001B[31m" + enemy.getName() + " has appeared!" + "\u001B[0m");
            Thread.sleep(1500);
        }
        Scanner scnr = new Scanner(System.in);

        boolean done = false;
        while (!done) {
            enemy.dialogue();
            Thread.sleep(1750);
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
                        if (enemy instanceof MiniBoss m) {
                            m.flirt();
                        }
                        else {
                            done = p.flirt(enemy, p);
                            Thread.sleep(2000);
                        }
                        goodinput = true;
                    }
                    case "3" -> {
                        p.flask();
                        goodinput = true;
                    }
                    case "4" -> {
                        p.flee();
                        if(enemy instanceof Girlfriend g) {
                            ending(2);
                        }
                        goodinput = true;
                        done = true;
                    }
                    case "5" -> p.file(enemy);

                    default -> {System.out.println("Your intelligence must be the size of a pea. Input again"); Thread.sleep(1500);}
                }
            }

            if(enemy.getHP() <= 0) {
                if(enemy instanceof Enemy e) {
                    e.giveLoot(p);
                }
                if(enemy instanceof Girlfriend g) {
                    g.giveMedal(p);
                }
                if (enemy instanceof MiniBoss m) {
                    m.deathDialogue();
                    m.giveLoot(p);
                }
                System.out.println("Combat over");
                done = true;
            }
            if (!(done)) {
                enemy.fight(p);
            }
            if(p.getHP() <= 0) {
                if(!(enemy instanceof Girlfriend)) {
                    Thread.sleep(1500);
                    System.out.println("\u0001B[31mYour attempt to fight for the love of your life ended because of " + enemy.getName() + "\u001B[0m");
                    p.death();
                }
                else {
                    ending(2);
                    gameOver = true;
                }

                done = true;
            }
        }
        if(!gameOver && p.getCompanions().size() > 0) {
            p.restCompanions();
        }
        Thread.sleep(1750);
    }

    public void introDialogue() throws InterruptedException {
        System.out.println("\n \n \n \n \n \n \n \n");
        System.out.println("Your eyelids slowly open. A new day dawns.");
        Thread.sleep(1500);
        System.out.println("You awaken in a place where most great journeys begin: \n a field");
        Thread.sleep(1500);
        System.out.println("You sit in silent contemplation \n after a few moments of deep thought about your life you decide that your girlfriend is the one you want to be with forever");
        Thread.sleep(1500);
        System.out.println("However, you feel not worthy of her love, so how do you get it?");
        Thread.sleep(1500);
        System.out.println("In order to assure she says yes, you decide to embark on an expedition, a journey, one to be told about for eons");
        Thread.sleep(1500);
        System.out.println("You get up and walk forward. Maybe after a long adventure, you will be ready");
        Thread.sleep(1500);
        System.out.println("As you walk over a hill, you can see a dense forest off in the distance.");
        Thread.sleep(1500);
        System.out.println("Your feet carry you onward.\nAs the canopy around you closes in, steadily darkening the path in front of you, you get the sense that something nefarious lurks in the darkness.");
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
        Weapon axe = new Weapon("Axe",55,30,"An American made axe that seems to be the property of some psycho");


        Armor overalls = new Armor("overalls", 20, 10, "Ain't much, but it's honest work");
        Armor noArmor = new Armor("Birthday Suit", 0, 0, "Nothing cheaper than a birthday suit");
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

        String ogreSuccess = "*Grunts happily*";
        ArrayList<Item> ogreLoot = new ArrayList<>();
        ArrayList<String> ogreBattleDialogue = new ArrayList<>();
        ogreBattleDialogue.add("*Grunts angrily*");
        ArrayList<String> ogreFlirtDialogue = new ArrayList<>();
        ogreFlirtDialogue.add("1 - Assert dominance by grunting louder \n" + "2 - Hand him a flower \n" + "3 - Smack the ground sensually");
        ogreFlirtDialogue.add("Grunts louder than before, somehow looking angrier and uglier");
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
        pBattleDialogue.add("*Glows threateningly*");
        ArrayList<String> pFlirtDialogue = new ArrayList<>();
        pFlirtDialogue.add("1 -  Joke about burning down the forest \n" + "2 - compliment its radiance \n" + "3 - admire the beauty of nature");
        pFlirtDialogue.add("*flies around looking even angrier*");
        pFlirtDialogue.add("*shines brighter, burning your retinas*");
        pFlirtDialogue.add(pSuccess);
        Enemy pixie = new Enemy (15, "Pixie", noArmor,magicWand , 8, pLoot,pSuccess,6,pBattleDialogue,pFlirtDialogue);

        String panSuccess = "YES! Together we shall vanquish the rising wage gap and distribute the wealth through violent revolution!";
        ArrayList<Item> panLoot = new ArrayList<>();
        ArrayList<String> panBattleDialogue = new ArrayList<>();
        panBattleDialogue.add("Who dares challenge the protector of the poor");
        ArrayList<String> panFlirtDialogue = new ArrayList<>();
        panFlirtDialogue.add("1 - describe your hate for the wealthy and love for the poor \n" + "2 - Talk about how much money you have \n" + "3 - compliment his bow");
        panFlirtDialogue.add(panSuccess);
        panFlirtDialogue.add("Then you deserve to be crushed by the common man, bourgeoisie pig.");
        panFlirtDialogue.add("It'll be the last thing you see");
        Enemy robinHood = new Enemy(30, "Robin Hood", noArmor, Bow, 4, panLoot, panSuccess, 5, panBattleDialogue, panFlirtDialogue);

        ArrayList<Item> bourneLoot = new ArrayList<>();
        String bourneSuccess = "Wow, that answered so many questions. How can I learn more?\n*You lure him onto your team with the promise of answers*";
        ArrayList<String> bourneBattleDialogue = new ArrayList<>();
        bourneBattleDialogue.add("You're bourne to die");
        ArrayList<String> bournFlirtDialogue = new ArrayList<>();
        bournFlirtDialogue.add("1 - Give him a fake ID\n2 - Tell him that you too have an identity crisis\n3 - Make him watch the Bourne Identity");
        bournFlirtDialogue.add("What am I, 15?");
        bournFlirtDialogue.add("I don't need sympathy, I need answers!");
        bournFlirtDialogue.add(bourneSuccess);
        Enemy jBourne = new Enemy(35, "Jason Bourne", noArmor, gun, 7, bourneLoot, bourneSuccess, 5, bourneBattleDialogue, bournFlirtDialogue);
//        Enemy Bond = new Enemy(30, "007", buisness, gun, 2, bondLoot, bondSuccess, 4, bondBattleDialogue, bondFlirtDialogue);
//        Enemy TuskenRaider = new Enemy(13, "Tusken Raider", overalls, laserRifle, 8, trLoot, trSuccess, 4, trBattleDialogue, trFlirtDesign);
//        Enemy Jawa = new Enemy(20, "Jawa", cloak, laserRifle, 3, jawaLoot, jawaSuccess, 4, jawaBattleDialogue, jawaFlirtDesign);
//        Enemy KingArthur = new Enemy(40, "King Arthur", suitOfArmor, sword, 7, arthurLoot, arthurSuccess,5, arthurBattleDialogue, arthurFlirtDialogue);
//        Enemy JohnWick = new Enemy(30, "John Wick", suit, buisness, gun, 2, wickLoot, wickSuccess, 3, wickBattleDialogue, wickFlirtDialogue)
//        snoopy
//        snoop dog
        String patSuccess = "That's bone. And the lettering is something called Silian Rail";
        ArrayList<Item> patLoot = new ArrayList<>();
        ArrayList<String> patBattleDialogue = new ArrayList<>();
        patBattleDialogue.add("Ever heard of Huey Lewis and the News?");
        ArrayList<String> patFlirtDialogue = new ArrayList<>();
        patFlirtDialogue.add("1 - Complement his business card\n" + "2 - Talk about your taste in music\n" + "3 - Talk about yourself");
        patFlirtDialogue.add(patSuccess);
        patFlirtDialogue.add("There is no band out there greater than Huey Lewis and the News and I would like to see your head on a pike");
        patFlirtDialogue.add("If you don't shut your fucking mouth, I will kill you.");
        Enemy patman = new Enemy(55,"Patrick Bateman",buisness,axe,4,patLoot,patSuccess,4,patBattleDialogue,patFlirtDialogue);
        //jar jar binks
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

        ArrayList<Enemy> Enemies = new ArrayList<>(Arrays.asList(beet, ogre,princessPeach,pixie, robinHood,BillNye,BreakBad,patman));        //contains one of the enemies in order of creation

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
            introDialogue();
        }
        String loc1Msg = "You enter what seems to be a forest. Huge, weeping trees tower above.";
        String loc2Msg = "You come across a magnificent castle. It must've stood here for centuries. You enter warily.";
        String loc3Msg = "You enter a desert. It's dry.";
        Queue<Location> locations = new LinkedList<>();

        ArrayList<Item> reginaLoot = new ArrayList<>();
        reginaLoot.add(peachDress);
        reginaLoot.add(heel);
        ArrayList<String> reginaBattle = new ArrayList<>();
        reginaBattle.add("Im not like a regular mom.  Im a cool mom");
        String reginaFlirt = "And right now, your getting on my last nerve! Switch";
        String reginaDeath = "Im going to forgive you because im a very Zen person.  And im on a lot of pain medication right now";
        String reginaIntro = "Get in loser.  We`re going shopping";
        MiniBoss reginaGeorge = new MiniBoss(75,"Regina George", peachDress,heel,4,reginaLoot,reginaFlirt,reginaIntro,reginaBattle,reginaDeath);

        ArrayList<Item> karenLoot = new ArrayList<>();
        karenLoot.add(peachDress);
        karenLoot.add(heel);
        ArrayList<String> karenBattle = new ArrayList<>();
        karenBattle.add("Well... Im kinda psychic.  I have a fifth sense.");
        String karenFlirt = "Why are you dressed so scary?";
        String karenDeath = "So that's against the rules, and you cant sit with us";
        String karenIntro = "On Wednesdays we wear pink";
        MiniBoss karen = new MiniBoss(90,"Karen Smith", peachDress,heel,6,karenLoot,karenFlirt,karenIntro,karenBattle,karenDeath);

        ArrayList<Item> gretchenLoot = new ArrayList<>();
        gretchenLoot.add(peachDress);
        gretchenLoot.add(heel);
        ArrayList<String> gretchenBattle = new ArrayList<>();
        gretchenBattle.add("thats so fetch");
        String gretchenFlirt = "Im sorry that people are so jealous of me.  But i can`t help it that im popular";
        String gretchenDeath = "Oh no, I cant say anything else until i have a parent or lawyer present";
        String gretchenIntro = "you can only wear your hair in a ponytail once a week, so i guess you chose today";
        MiniBoss gretchen = new MiniBoss(100,"Gretchen Weiners", peachDress,heel,8,gretchenLoot,gretchenFlirt,gretchenIntro,gretchenBattle,gretchenDeath);

        Location loc1 = new Location("Forest", difficulty, randomizeEnemies(Enemies), loc1Msg,reginaGeorge);
        Location loc2 = new Location("Castle", difficulty, randomizeEnemies(Enemies), loc2Msg,karen);
        Location loc3 = new Location("Desert", difficulty, randomizeEnemies(Enemies), loc3Msg,gretchen);


        Girlfriend gf = makeGirlFriend(difficulty);


        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        Shop s = new Shop(allItems);
        Queue<MiniBoss> miniBosses= new LinkedList();
        miniBosses.add(reginaGeorge);
        miniBosses.add(karen);
        miniBosses.add(gretchen);

        while  (locations.size() > 0) {
            location(player, locations.peek());
            miniBossFight(player,miniBosses.poll(),locations.poll());
            s.shopMenu(player);
        }

        System.out.println("After a long journey you make it to your girlfriends house.");
        Thread.sleep(1000);
        System.out.println("You knock on her door to see " + gf.getName() + " standing in front of you.");
        Thread.sleep(1000);
        System.out.println("She looks rather angry with you and it seems like she also wants to test you to see if you are worthy of dating her");
        combat(player,gf);

        if (gf.getFlirtLimit() == 5) {
            ending(0);
        }
        else {
            ending(1);
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
                System.out.println("You continue on your path, determined to survive the oncoming hordes as you go to the next location");
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
                    p.equipItem(i);
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

    public Girlfriend makeGirlFriend(int difficulty){
        //IMPORTANT NOTE: flirtResponse's first string (index 0) must be a response for succeeding in the flirt. Each string after that (index 1 on) corresponds to an option in flirtOptions
        //For example, this means that if there are 6 total options in flirtOptions (numbered 1-6), the size of flirtResponses must be 7.
        //(index 0 holds success response, where indexes 1-6 hold responses to options 1-6)

        ArrayList<String> girlDialogue = new ArrayList<>();
        ArrayList<String> girlFlirtDialogue = new ArrayList<>();
        ArrayList<String> girlFlirtResponses = new ArrayList<>();
        String girlFlirtSuccess;
        switch (difficulty) {
            case 1 -> {
                Weapon IQ = new Weapon("Massive IQ",300,45,"IQ that is great enough to catch even the creepiest of costumed freaks");
                Armor glasses = new Armor("Glasses",200,11,"A pair of glasses that always seem to fall off at inopportune times");
                //The correct options are 3 and 5
                girlFlirtSuccess = "35";
                girlDialogue.add("I'm going to have to solve the mystery of the single boyfriend");
                girlFlirtDialogue.add("1 - give her a scooby snack\n" + "2 - talk about how her glasses look nice\n" + "3 - Solve a mystery that she has been troubled over for a long time");
                girlFlirtDialogue.add("4 - Rant about 5th century war strategies\n" + "5 - Explain how DB Cooper escaped to Uganda where he ran an underground child sweatshop\n" + "6 - say the greatest mystery is what we learned along the way");

                girlFlirtResponses.add("Jinkies! I...I think I kinda...you could, you know...be part of the gang with me from now on.");
                girlFlirtResponses.add("Eww those things taste gross. How can Shaggy eat those");
                girlFlirtResponses.add("Honestly I hate them they always fall off my face");
                girlFlirtResponses.add("Oh really you have a mystery to solve. Mysteries are my favorite thing on the planet");
                girlFlirtResponses.add("I smart not a history buff");
                girlFlirtResponses.add("OMG is that actually what happened I'll have to investigate with the gang");
                girlFlirtResponses.add("Those types of endings always suck");
                return new Girlfriend(500,"Velma",glasses,IQ,5.5,difficulty,girlDialogue,girlFlirtDialogue,girlFlirtResponses,girlFlirtSuccess);
            }
            case 2 ->{//create difficulty 2 gf
                //Padme Amidala
                girlFlirtSuccess = "123";
                return new Girlfriend();
            }
            case 3 -> {//create difficulty 3 gf
                //Rasputin
                Weapon ras = new Weapon("Sleeper Simulant",1000,55,"Now that is a Destiny 2 reference");
                Armor rarmor = new Armor("Royal Russian Garb",999,150,"The attire of an eccentric Russian Man");
                girlFlirtSuccess = "159";
                girlDialogue.add("Try as you might many have made attempts on my life and many have failed");
                girlFlirtDialogue.add("1 - Complement his taste in woman\n" + "2 - Ask him to dance\n" + "3 - Offer him some wine");
                girlFlirtDialogue.add("4 - Ask about his role in current Russian politics\n" + "5 - Show him your priceless vodka collection\n" + "6 - Ask him to teach you how to ride a bear");
                girlFlirtDialogue.add("7 - Talk about current Russian political strategies involving the current Czar\n" + "8 - Turn on Rasputin and attempt to replicate the silly little Russian dance\n" + "9 - Offer him a Russian Queen");

                girlFlirtResponses.add("Your words give me the utmost respect and trust for you so I will now drink this wine i got from a mysterious stranger");
                girlFlirtResponses.add("My taste in women is any that lay in my bed");
                girlFlirtResponses.add("I appreciate the offer as I am always in the mood to do a silly little Russian dance");
                girlFlirtResponses.add("The last time I had some wine that was offered to me I was poisoned");
                girlFlirtResponses.add("As a true prophet I will never discuss my ideals to a peasant like yourself");
                girlFlirtResponses.add("Vodka: a Russian's lifeblood");
                girlFlirtResponses.add("Only an absolute madman would attempt to ride a bear least they wish to be put-in its mouth");
                girlFlirtResponses.add("All I will tell you is that I cured the Czar's boy you are not qualified to know more than that");
                girlFlirtResponses.add("Your attempts to replicate my beauty are pitiful. Pathetic");
                girlFlirtResponses.add("As Russia's Greatest love machine I am pleased with this offering.");
                return new Girlfriend(550,"Rasputin",rarmor,ras,6,difficulty,girlDialogue,girlFlirtDialogue,girlFlirtResponses,girlFlirtSuccess);
            }
        }
        return null;
    }
    public void Credits() {
        var frame = new JFrame();
        var icon = new ImageIcon("Love QUest.png");
        var label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);    }

    public void ending(int goodEnd) throws InterruptedException {
        if(goodEnd == 0){
            System.out.println("Congratulations, you achieved the Good Ending");
            Thread.sleep(1000);
            System.out.println("With your amassed clout and your amazing pick-up lines you manage to convince your Girlfriend to fully date you.");
            Thread.sleep(2000);
            System.out.println("She has some pain from how much she got hit but shes still loves you");
            Thread.sleep(2000);
            System.out.println("If you want more pay $30 for a better written ending");
            Thread.sleep(1000);
            Credits();
        }
        else if (goodEnd == 1){
            System.out.println("You may have won, but at a cost of the Bad Ending");
            Thread.sleep(1000);
            System.out.println("In your attempt to convince your girlfriend to stay with you end up killing your girlfriend");
            Thread.sleep(2000);
            System.out.println("The cops are quick to arrive on the scene and after seeing your weapon the cops arrest and detain you");
            Thread.sleep(2000);
            System.out.println("it has been 5 years since that fateful journey");
            Thread.sleep(2000);
            System.out.println("you now spend every day and night locked in a small prison room with no one to see and no one to talk to");
            Thread.sleep(3000);
            System.out.println("you continue to serve out your life sentence in hopes of escaping one day, but for now you wait...");
            Thread.sleep(3500);
            Credits();
        }
        else if (goodEnd == 2) {
            System.out.println("in fear of your girlfriends wrath you flee from the scene");
            System.out.println("your journey has come to and end, and as you look around you see your companions who gave their lives for a cause you couldn't bring yourself to complete");
            System.out.println("you return to that field where you sat before all of this began");
            System.out.println("as you lay back down to think some more, you fall asleep");
            Thread.sleep(5000);
            introDialogue();
            start(1,"a failed hero");
        }
        else if(goodEnd == 3) {
            System.out.println("What a pathetic display of ineptitude.");
            Thread.sleep(2500);
            System.out.println("You really thought you could defeat your girlfriend with so little clout?.");
            Thread.sleep(3000);
            System.out.println("You lack ambition, and so did your friends.");
            Thread.sleep(3500);
            System.out.println("Goodbye, incel.");
            Thread.sleep(3000);
            Credits();
        }
    }
   }