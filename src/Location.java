import java.util.ArrayList;
import java.util.Stack;

public class Location {
    private String name;
    private int difficulty;
    private int numRooms;
    private String currentLoc;       //keeps track of which location the player is currently in
    private int progress;            //keeps track of how many rooms the player has completed within each location
    private Stack<Room> rooms;

    //default constructor
    public Location() {
        this.name = null;
        this.difficulty = 0;
        this.numRooms = 0;
        this.currentLoc = null;
        this.progress = 0;
        this.rooms = new Stack<>();
    }

    //constructor given parameters
    public Location(String name, int difficulty, String currentLoc, Stack<Room> rooms) {
        this.name = name;
        switch(difficulty) {
            case 1 -> numRooms = 3;
            case 2 -> numRooms = 5;
            case 3 -> numRooms = 7;
        }
        this.currentLoc = currentLoc;
        this.progress = 0;

        this.rooms = new Stack<>();
        this.rooms.addAll(rooms);
    }

    //checks whether player has completed a location or not
    public boolean checkProgress(int progress) {
        return false;
    }

    //generates a random assortment of rooms up to the numRooms attached to this location
    public void generateRooms() {}

    //getters
    public String getName() {return name;}
    public int getDifficulty() {return difficulty;}
    public int getNumRooms() {return numRooms;}
    public String getCurrentLoc() {return currentLoc;}
    public int getProgress() {return progress;}

    //setters
    public void setName(String name) {this.name = name;}
    public void setDifficulty(int difficulty) {this.difficulty = difficulty;}
    public void setNumRooms(int numRooms) {this.numRooms = numRooms;}
    public void setCurrentLoc(String currentLoc) {this.currentLoc = currentLoc;}
    public void setProgress(int progress) {this.progress = progress;}
}
