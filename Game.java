import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean finished;
    private int robo = 0;
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
            if (ran == 2) {
                dummy1 = player2;
                //code dummy is changed
                player2 = player1;
                player1 = dummy1;
            }
        }
        turn++;
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
        if (robo == 0) {
            Scanner ro = new Scanner(System.in);
            System.out.println("Would you like to play against a robot?: Y/N");
            String response = ro.nextLine();
            while (!(response.trim().toUpperCase().equals("Y") || response.trim().toUpperCase().equals("N"))) {
                System.out.println("Invalid response. Try again. Y/N: ");
                response = ro.nextLine();
            }
    
            if (response.trim().toUpperCase().equals("Y")) {
                robo = 1;
            }
            else {
                robo = 2;
            }
        }

        finished = false;
        Board.populate();
        Board.setMaxGuess();
        advanceTurn();
        while (!finished) {
            Scanner sc = new Scanner(System.in);
            System.out.println("It is " + currentPlayer.getName() + "'s turn.");
            System.out.println("There are " + Board.getNumPieces() + " remaining.");
            System.out.println("You can remove up to " + Board.getMaxGuess() + " pieces. How many pieces would you like to remove?");
            int guess = sc.nextInt();

            while (!isValid(guess)) {
                System.out.println("That was an invalid guess, try again.");
                guess = sc.nextInt();
            }

            Board.removePieces(guess);
            Board.setMaxGuess();

            if (Board.getNumPieces() == 0) {
                finished = true;
            }
            
            if (turn % 2 == 1) {
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
            this.play();
        }
    }

    public String getPlayerName(int n) {
        if (n == 1) {
            return player1.getName();
        }

        else {
            return player2.getName();
        }
    }

    public int getPlayerScore(int n) {
        if (n == 1) {
            return player1.getScore();
        }

        else {
            return player2.getScore();
        }
    }

    private boolean playAgain() {
        System.out.println("Would you like to play again? Y/N: ");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();
        while (!(response.trim().toUpperCase().equals("Y") || response.trim().toUpperCase().equals("N"))) {
            System.out.println("Invalid response. Try again. Y/N: ");
            response = sc.nextLine();
        }

        if (response.trim().toUpperCase().equals("Y")) {
            return true;
        }
        else {
            return false;
        }
    }
}
