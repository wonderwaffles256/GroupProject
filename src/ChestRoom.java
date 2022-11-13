import java.util.Random;

public class ChestRoom extends Location{

    public ChestRoom(String name,int difficulty, int currentLoc, int progress){
        super(name,difficulty,currentLoc,progress);
    }

    //returns some number of CORN from the chest
    public int openChest(){
        int va = 50;//val will be some random value between # and #
        return va;
    }
}
