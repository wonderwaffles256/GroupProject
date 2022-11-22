import java.util.ArrayList;
import java.util.Stack;

public class Location {
    private String name;
    private int difficulty;
    private int numRooms;
    private char currentLoc;         //keeps track of which location the player is currently in (A,B,C,...etc.)
    private int progress;            //keeps track of how many rooms the player has completed within each location
    private Stack<Room> rooms;       //holds a set of rooms generated for this location

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
    }

    /**
     * constructor
     * @param name - name of the location
     * @param difficulty - difficulty set by the endgame girlfriend
     * @param currentLoc - number associated with current location
     */
    public Location(String name, int difficulty, char currentLoc, int numRooms) {
        this.name = name;
        switch(difficulty) {
            case 1 -> this.numRooms = 3;
            case 2 -> this.numRooms = 5;
            case 3 -> this.numRooms = 7;
            default -> this.numRooms = numRooms;
        }
        this.currentLoc = currentLoc;
        this.progress = 0;

        this.rooms = new Stack<>();
        this.rooms.addAll(generateRooms());
    }

    /**
     * checks whether player has completed a location or not
     * @param progress - keeps track of how many rooms the player has completed within each location
     * @return boolean - true if location is complete
     */
    public boolean checkProgress(int progress) {
        return false;
    }

    /**
     * generates a random assortment of rooms up to the numRooms attached to this location
     * @return Stack<Room> - stack holds each generated room
     */
    public Stack<Room> generateRooms() {
        return new Stack<>();
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
