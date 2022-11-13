public class ChestRoom extends Location{
    Item It;

    public ChestRoom(String name,int difficulty,Item it){
        super(name,difficulty);
        It = it;
    }

    public Item acquireItem(){
        return It;
    }
}
