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
        Player dummy1;
        if (turn == 0) {
            int ran = (int) (Math.random() * 2 + 1);
            System.out.println("random number: " + ran);
            if (ran == 2) {
                dummy1 = new Player(player2.getName(), player2.getScore());
                player2 = player1;
                player1 = dummy1; 
                System.out.println(player1.getName());
                System.out.println(player2.getName());
            }
        }
        turn++;
        System.out.println(turn);
        if (turn % 2 == 1) {
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
        Board.populate();
        Board.setMaxGuess();
        while (!finished) {
            Scanner sc = new Scanner(System.in);
            advanceTurn();
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
        System.out.println(currentPlayer.getName() + " has won this round! " + currentPlayer.getName() + " will receive 1 point.");
        currentPlayer.incrScore();
        if (playAgain()) {
            play();
        }

        System.out.println("The game has ended! " + player1.getName() + " has " + player1.getScore() + " points." + player2.getName() + " has " + player2.getScore() + " points.");
    }

    private boolean playAgain() {
        System.out.println("Would you like to play again? Y/N: ");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();
        while (!(response.trim().toUpperCase().equals("Y") || response.trim().toUpperCase().equals("N"))) {
            System.out.println("Invalid response. Try again. Y/N: ");
            response = sc.nextLine();
        }
        if (response.equals("Y")) {
            return true;
        }
        else {
            return false;
        }
    }
}
