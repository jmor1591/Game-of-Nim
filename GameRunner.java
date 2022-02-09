/**
 * Project 2.5.11
 *
 * GameRunner Class for the Game of Nim 
*/
public class GameRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Game of Nim!");

        Board.populate(); // static method call

        Game nim = new Game();
        // NOTE: uncomment to debug Game.play()
        nim.play();
        System.out.println("The game has ended! " + nim.getPlayerName(1) + " has " + nim.getPlayerScore(1) + " points. " + nim.getPlayerName(2) + " has " + nim.getPlayerScore(2) + " points.");
    }
}