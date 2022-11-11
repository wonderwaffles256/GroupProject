public class Item {
    private String name;
    private int value;

    //empty constructor
    public Item() {
        name = null;
        value = 0;
    }

    //constructor given input
    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    //getters
    public String getName() {return name;}
    public int getValue() {return value;}

    //setters
    public void setName(String name) {this.name = name;}
    public void setValue(int value) {this.value = value;}

}
