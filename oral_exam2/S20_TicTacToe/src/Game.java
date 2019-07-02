/**
 * A class that determines all action to be taken for the game to run correctly. The Game class acts a controller
 * that mediates between the {@link Board} and {@link Player} classes. Game uses the Board to give each player a visual
 * of the game, and uses the Player classes as the input for the "playing" of the game. Game is great for keeping the
 * Board and the Players separate, and for running the logic of the Tic Tac Toe game.
 */
public class Game {

    /**
     * Array of players
     */
    private Player[] players;
    /**
     * The {@link Board} object
     */
    private Board board;
    /**
     * The state of the game. 0 means Player 1's turn, 1 mean Player 2's turn, and 2 means a player has won
     */
    private int gameState;

    /**
     * The only constructor for a Game object is an input of two players (players are either Human or Computer). In the
     * body of the constuctor, the {@link Game#players} array is initialized and the {@link Board} object {@link Game#board}
     * is initialized.
     * @param player1 Player 1
     * @param player2 Player 2
     */
    Game(Player player1, Player player2) {

        players = new Player[] {player1,player2};
        board = new Board();

    }

    /**
     * The playGame method is where all the classes come together for the game to be played. There are many different
     * moving parts to this method but the most important ones, the in-game while loop and the validation while loop.
     * The in-game loop is the while loop that encompasses almost the whole method and it loops only when there are
     * spaces left to be played on. The validation loop is a while loop inside the in-game loop that is for input from
     * the players and the validation of the input, so all moves in the game are made inside this loop.
     */
    public void playGame() {

        gameState = 0;

        while(board.stillPlayable()) {

            System.out.println(board.boardToString());

            boolean validation = false;

            while (!validation) {

                PlayedSpace move = new PlayedSpace(players[gameState].makeMove(),players[gameState].getSymbol());

                validation = board.validate(move);

                if (validation) {
                    board.updateBoard(move);
                    if (players[gameState].getClass().getName() == "ComputerPlayer") {
                        System.out.println("The Computer moved to " +
                                Integer.toString(move.getPosition().getVertical()+1) + " " +
                                Integer.toString(move.getPosition().getHorizontal()+1));
                    }
                } else if (players[gameState].getClass().getName() == "HumanPlayer") {
                    System.out.println(Integer.toString(move.getPosition().getVertical()+1) + " " +
                            Integer.toString(move.getPosition().getHorizontal()+1) +
                            " has already been played");
                }

            }

            System.out.println("\n");

            if(winnerCheck()) {

                System.out.println("Player " + Integer.toString(gameState + 1) + " Wins!");
                gameState = 2;
                break;
            }

            if (gameState == 1) gameState--;
            else gameState++;

        }

        if (!(gameState == 2)) {
            System.out.println("Draw!");
        }

        System.out.println(board.boardToString());

    }

    /**
     * This method checks for a winner, all diagonal, vertical, and horizontal paths are checked for a winning trio.
     * Using the Board object's spaces we can check if there is a path of matching symbols, if there is then we have a
     * winner.
     * @return Boolean if there is a winner
     */
    private boolean winnerCheck() {

        for(int i = 0; i < 3; i++) {

            if (board.spaces[i][0].getSymbol() == board.spaces[i][1].getSymbol() &&
                board.spaces[i][1].getSymbol() == board.spaces[i][2].getSymbol() &&
                board.spaces[i][0].getSymbol() == players[gameState].getSymbol()) return true;

            if (board.spaces[0][i].getSymbol() == board.spaces[1][i].getSymbol() &&
                board.spaces[1][i].getSymbol() == board.spaces[2][i].getSymbol() &&
                board.spaces[0][i].getSymbol() == players[gameState].getSymbol()) return true;

        }

        if (board.spaces[0][2].getSymbol() == board.spaces[1][1].getSymbol() &&
            board.spaces[1][1].getSymbol() == board.spaces[2][0].getSymbol() &&
            board.spaces[0][2].getSymbol() == players[gameState].getSymbol()) return true;

        if (board.spaces[0][0].getSymbol() == board.spaces[1][1].getSymbol() &&
            board.spaces[1][1].getSymbol() == board.spaces[2][2].getSymbol() &&
            board.spaces[2][2].getSymbol() == players[gameState].getSymbol()) return true;

        return false;

    }

}
