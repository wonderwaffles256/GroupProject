public class ChestRoom extends Location{
    Item It;

    public ChestRoom(String name,int difficulty, int currentLoc, int progress, Item it){
        super(name,difficulty,currentLoc,progress);
        It = it;
    }

    public Item acquireItem(){
        return It;
    }
}
