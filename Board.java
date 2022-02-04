public class Board {
    private static int pieces;
    private static int maxGuess;

    public static void populate() {
        // TODO: program this
    }

    //Accessors
    public static int getMaxGuess(){
        return maxGuess;
    }

    public static int getNumPieces() {
        return pieces;
    }


    //Mutators
    public static void removePieces(int n) {
        // 
        pieces -= n;
    }

    public static void setMaxGuess() {
        maxGuess = (int) (pieces / 2);
        if (pieces == 1) {
            maxGuess = 1;
        }
    }
}