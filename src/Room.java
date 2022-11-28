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
//        treasureRoom = isTreasureRoom();
    }

    public Room(Chest c, String name) {
        this.name = name;
        this.c = c;
        this.e = null;
        completed = false;
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

//    public boolean isTreasureRoom() {
//        Random r = new Random();
//       int num = (r.nextInt(10)+1);
//       if (num == 7) {
//           return true;
//       }
//       return false;
//    }
}

