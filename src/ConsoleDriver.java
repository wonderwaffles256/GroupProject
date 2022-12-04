import java.util.*;
//TODO make girlfriend mainly needs dialogue
//TODO port console driver over to runGame
//TODO make more enemies-
//TODO delete unused code
//TODO balance stuff
//TODO make gfs for difficulties

public class ConsoleDriver {
    public static void main(String[] args) throws InterruptedException {
        //bulk of logic elsewhere
        game game = new game();
        Scanner scnr = new Scanner(System.in);
        System.out.println("What difficulty would you like to play on? \n Enter 1,2 or 3 for easy, medium, or hard");
        int difficulty = scnr.nextInt();
        System.out.println("Welcome! Before you embark on your journey please enter your name");
        String name = scnr.next();
        game.start(difficulty,name);
    }

}
