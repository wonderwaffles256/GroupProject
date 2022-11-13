public class Location {
    private String name;
    private int difficulty;
    private int numRooms;
    private int currentLoc;       //keeps track of which location the player is currently in
    private int progress;         //keeps track of how many rooms the player has completed within each location

    public Location() {
        this.name = null;
        this.difficulty = 0;
        this.numRooms = 0;
        this.currentLoc = 0;
        this.progress = 0;
    }

    public Location(String name, int difficulty, int currentLoc, int progress) {
        this.name = name;
        switch(difficulty) {
            case 1 -> numRooms = 3;
            case 2 -> numRooms = 5;
            case 3 -> numRooms = 7;
        }
        this.currentLoc = currentLoc;
        this.progress = progress;
    }

    //checks whether player has completed a location or not
    public boolean checkProgress(int progress) {
        return false;
    }
}
