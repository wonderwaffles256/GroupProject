import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;


public class Location {
    private String name;
    private int difficulty;
    private int numRooms;
    private char currentLoc;         //keeps track of which location the player is currently in (A,B,C,...etc.)
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
        this.currentLoc = ' ';
        this.progress = 0;
        this.rooms = new Stack<>();
        locationEnemies = new ArrayList<>();
        entranceMessage = "You enter a strange new location";
    }
    public boolean isCompleted() {
        return progress == numRooms;
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

    /**
     * checks whether player has completed a location or not
     * @param progress - keeps track of how many rooms the player has completed within each location
     * @return boolean - true if location is complete
     */
    public boolean checkProgress(int progress) {
        return progress == numRooms;
    }

    /**
     * generates a random assortment of rooms up to the numRooms attached to this location
     * @return Stack<Room> - stack holds each generated room
     */
    public void generateRooms() {
        Random rand = new Random();
        for(int i=0; i < numRooms; i++) {
            String name = getName() + i;
            boolean randBool = rand.nextBoolean(); // generate a random boolean to determine whether chest or combat room
            if (randBool) {
                Chest c = new Chest(); // TODO: make this generate random loot.
                Room r = new Room(c,name);
                rooms.push(r);
            } else { // TODO: fix if not enough enemies
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

    //getters
    public String getName() {return name;}
    public int getDifficulty() {return difficulty;}
    public int getNumRooms() {return numRooms;}
    public char getCurrentLoc() {return currentLoc;}
    public int getProgress() {return progress;}

    //setters
    public void setName(String name) {this.name = name;}
    public void setDifficulty(int difficulty) {this.difficulty = difficulty;}
    public void setNumRooms(int numRooms) {this.numRooms = numRooms;}
    public void setCurrentLoc(char currentLoc) {this.currentLoc = currentLoc;}
    public void setProgress(int progress) {this.progress = progress;}
}
