import java.sql.SQLOutput;
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

    /**
     * getter for the name of room
     * @return name of room
     */
    //getters
    public String getName() {return name;}
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
        return c.getLoot();
    }
}

