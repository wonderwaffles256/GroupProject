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

    //setters + getters
    public String getName() {return name;}
    public boolean getCompleted() {return completed;}

    public void setName(String name) {this.name = name;}
    public void setCompleted(boolean completed) {this.completed = completed;}
}
