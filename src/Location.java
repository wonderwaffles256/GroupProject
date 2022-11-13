public class Location {
    private String name;
    private int difficulty;
    private int numRooms;

    public Location() {
        this.name = null;
        this.difficulty = 0;
        this.numRooms = 0;
    }

    public Location(String name, int difficulty) {
        this.name = name;
        switch(difficulty) {
            case 1 -> numRooms = 3;
            case 2 -> numRooms = 5;
            case 3 -> numRooms = 7;
        }
    }
}
