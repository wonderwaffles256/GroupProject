import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

/**
 * a location contains a set amount of rooms that the player will work through and once that has been completed, they will enter the next location
 */
public class Location {
    private String name;
    private int difficulty;
    private int numRooms;
    private int progress;            //keeps track of how many rooms the player has completed within each location
    private Stack<Room> rooms;       //holds a set of rooms generated for this location
    private ArrayList<Enemy> locationEnemies;
    private String entranceMessage; // message printed on instantiation of this room

    /**
     * default constructor
     */
    public Location() {
        this.name = null;
        this.difficulty = 0;
        this.numRooms = 0;
        this.progress = 0;
        this.rooms = new Stack<>();
        locationEnemies = new ArrayList<>();
        entranceMessage = "You enter a strange new location";
    }

    /**
     * constructor
     * @param name - name of the location
     * @param difficulty - difficulty set by the endgame girlfriend
     */
    public Location(String name, int difficulty, ArrayList<Enemy> locationEnemies, String entranceMessage) {
        this.name = name;
        switch(difficulty) {
            case 1 -> this.numRooms = 3;
            case 2 -> this.numRooms = 5;
            case 3 -> this.numRooms = 7;
        }
        this.locationEnemies = new ArrayList<>();
            this.locationEnemies.addAll(locationEnemies);
        this.progress = 0;
        this.rooms = new Stack<>();
        generateRooms();
        this.entranceMessage = entranceMessage;
    }

    //getters
    public String getName() {return name;}
    public ArrayList<Enemy> getLocationEnemies() {
        return locationEnemies;
    }

    //setters
    public void setName(String name) {this.name = name;}
    public void setProgress(int progress) {this.progress = progress;}

    public boolean isCompleted() {
        return progress == numRooms;
    }

    /**
     * generates a random assortment of rooms up to the numRooms attached to this location
     * each room has a 1/10 chance of being a chest room
     * @return Stack<Room> - stack holds each generated room
     */
    public void generateRooms() {
        Random rand = new Random();
        for(int i=0; i < numRooms; i++) {
            String name = getName() + i;
            int num = (rand.nextInt(10)+1);; // generate a random number to determine whether chest or combat room
            if (num == 5) {
                Chest c = new Chest();
                Room r = new Room(c,name);
                rooms.push(r);
            } else {
                Enemy e = locationEnemies.get(i);
                Room r = new Room(e,name);
                rooms.push(r);
            }
        }
    }
    public Stack<Room> getRooms() {
        return rooms;
    }

    /**
     * Depending on its type, this room's toString will produce a related output.
     */
    @Override
    public String toString() {
        return entranceMessage;
    }
}
