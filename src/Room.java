public class Room {
    private String name;
    private boolean completed;

    //default constructor
    public Room() {
        name = null;
        completed = false;
    }

    //constructor given parameters
    public Room(String name) {
        this.name = name;
        completed = false;
    }

    //setter + getter
    public String getName() {return name;}

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setName(String name) {
        this.name = name;
    }
}
