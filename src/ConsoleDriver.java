import java.util.*;
//TODO balance stuff - everyone
//TODO javadoc methods - everyone

/**
 * This method runs the entirety of the game mainly by calling the game method. The method only really asks for a difficulty and then plays the game
 */
public class ConsoleDriver {
    public static void main(String[] args) throws InterruptedException {
        //bulk of logic elsewhere
        boolean done = false;
        while(!done) {
            try {
                game game = new game();
                Scanner scnr = new Scanner(System.in);
                System.out.println("What difficulty would you like to play on? \n Enter 1,2 or 3 for easy, medium, or hard");
                int difficulty = scnr.nextInt();
                System.out.println("Welcome! Before you embark on your journey please enter your name");
                String name = scnr.next();
                game.start(difficulty,name);
                done = true;
            }
            catch (Exception e) {
                System.out.println("Enter something normal, you troglodyte.");
            }
        }
    }

}
