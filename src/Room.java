import java.util.Random;

/**
 * user will travel throughout different room objects and complete them one by one
 */
public class Room {
    private String name;
    private boolean completed;
    private Enemy e;
    private Chest c;
    private boolean treasureRoom;
    /**
     * default constructor for rooms
     */
    public Room() {
        name = null;
        completed = false;

        Random r = new Random();
        int num = (r.nextInt(5)+1);
    }

    /**
     * constructor given the name of the room
     * @param e enemy in room if not a treasure room
     * completed is set to false because the room has yet to be completed
     */

    //constructor given parameters
    public Room(Enemy e, String name) {
        this.name = name;
        this.e = e;
        this.c = null;
        completed = false;
        treasureRoom = false;
    }

    public Room(Chest c, String name) {
        this.name = name;
        this.c = c;
        this.e = null;
        completed = false;
        treasureRoom = true;
    }

    public Room(String name) {
        this.name = name;
    }

    public boolean hasEnemy() {
        return e != null;
    }

    /**
     * getter for the name of room
     * @return name of room
     */
    //setter + getter
    public String getName() {return name;}

    /**
     * getter for completion status of room
     * @return if room is completed or not
     */

    public boolean getCompleted() {return completed;}

    /**
     * sets the room as completed or not
     * @param completed boolean value that tracks to see if the room is completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Enemy getEnemy() {
        return e;
    }

    /**
     * setter for the name of the room
     * @param name name for the room
     */

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTreasureRoom() {
        return treasureRoom;
    }

    public Item getChest() {
        Item i = c.getLoot();
        System.out.println("\u001B[35m" + "You come across an old chest");
        if (i instanceof Weapon) {
            System.out.println("You inspect the weapon" + "\u001B[0m");

        }
        else if (i instanceof Consumable) {
            System.out.println("You inspect the drink"+ "\u001B[0m");

        }
        else if (i instanceof Armor) {
            System.out.println("You inspect the Armor"+ "\u001B[0m");

        }
        else {
            System.out.println("You inspect the item"+ "\u001B[0m");
        }
        return i;
    }
}

