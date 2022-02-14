import java.util.Scanner;

public class Player {
    private String name;
    private int score;

    public Player()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?: ");
        this.name = sc.nextLine();
        System.out.println("Welcome to the game, " + this.name + "!\n");
    }

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void incrScore() {
        this.score += 1;
    }
}
