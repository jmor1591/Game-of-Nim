import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean finished;
    static int turn = 0;

    public Game() {
        // TODO: program this
        player1 = new Player();
        player2 = new Player();
        finished = false;
    }

    public void advanceTurn() {
        turn++;
        if (turn % 2 == 0) {
            currentPlayer = player1;
        }
        else {
            currentPlayer = player2;
        }
    }

    private boolean isValid(int a){
        if (a <= Board.getMaxGuess()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void play() {
        // TODO: program this
        while (!finished) {
            Scanner sc = new Scanner(System.in);
            System.out.println("It is " + currentPlayer.getName() + "'s turn.");
            System.out.println("There are " + Board.getNumPieces() + " remaining.");
            System.out.println("You can remove up to " + Board.getMaxGuess() + " pieces. How many pieces would you like to remove?");
            int guess = sc.nextInt();

            if (isValid(guess)) {
                Board.removePieces(guess);
                Board.setMaxGuess();
            }

            if (Board.getNumPieces() == 0) {
                finished = true;
                turn++;
            }
            
            if (turn % 2 == 0) {
                player1 = currentPlayer;
            }
            else {
                player2 = currentPlayer;
            }
            advanceTurn();
        }
        System.out.println(currentPlayer.getName() + " has won this round!" + currentPlayer.getName() + )
    }

    private boolean playAgain() {
        // TODO: program this
        return true; // placeholder value for now
    }
}
