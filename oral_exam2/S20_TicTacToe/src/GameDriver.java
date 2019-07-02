import java.util.Scanner;

/**
 * A class that used to setup the physical game before it is started, and then calls the game to be run.
 */
public class GameDriver {

    /**
     * The main method acts as the driving force for the game. It outputs the welcoming statements to the user, uses
     * the playerChoice to get how many {@link HumanPlayer}s and/or {@link ComputerPlayer}s will be playing, and
     * initializes the {@link Game} object. Once the playGame method is called the rest of the game is in the hands of
     * that method.
     * @param args
     */
    public static void main(String args[]) {

        System.out.println("Welcome to Tic Tac Toe");
        System.out.println("Making moves is simple it is just based on the row and column you type in");
        System.out.println("Ex. You would type something like '1 2' when asked to move");
        System.out.println("You will be informed of moves that are not valid\n");

        Player player1, player2;

        System.out.println("What will Player1 be, Human or Computer:");
        player1 = playerChoice('X');
        System.out.println("\nWhat will Player2 be, Human or Computer:");
        player2 = playerChoice('0');

        Game game = new Game(player1, player2);

        game.playGame();

    }

    /**
     * This method is used by both players and is meant to be used as a way for you to choose what type of players you
     * want
     * @param symbol The symbol that the player will use throughout the game
     * @return The {@link Player} object for that player
     */
    static Player playerChoice(Character symbol) {

        while (true) {

            Scanner input = new Scanner(System.in);
            String string = input.next();
            if (string.contains("Human")) {
                return new HumanPlayer(symbol);
            } else if (string.contains("Computer")) {
                return new ComputerPlayer(symbol);
            }

            System.out.println("\nNot a valid player type");

        }

    }

}
