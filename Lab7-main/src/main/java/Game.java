import java.util.Collections;

/**
 * This class holds our game board and two players.
 * This is where we keep our turn-based logic.
 */

public class Game {
    GameBoard board;
    Player playerOne;
    Player playerTwo;
    Game(int numRows, int numColumns, Player p1, Player p2) {
        p1.setTurn(true);
        p2.setTurn(false);
        this.playerOne = p1;
        this.playerTwo = p2;
        this.initializeGameBoard(numRows, numColumns);
    }

    private void initializeGameBoard(int numRows, int numColumns) {
        this.board = new GameBoard(numRows, numColumns);
    }

    GameBoard getBoard() {
        return this.board;
    }

    Player getCurrentPlayer() {
        return this.isTurn(playerOne) ? this.playerOne : this.playerTwo;
    }

    Player getOpponentPlayer() {
        return this.isTurn(playerOne) ? this.playerTwo : this.playerOne;
    }

    /**
	 * Checks if player's turn
	 *
	 * @param player the player who's turn to check
     * @returns if it's player's turn
	 */
    boolean isTurn(Player player) {
        return player.isTurn();
    }

    BoardSquare[][] getBoardSquares() {
        return this.getBoard().getSquares();
    }

    /**
	 * Switches each player's turn. Switch P1's turn from previous state
     * and set P2 of the opposite of that, because P2 is always the opposite of P1.
	 */
    void changeTurn() {
        this.playerOne.setTurn(!this.playerOne.isTurn());
        this.playerTwo.setTurn(!this.playerOne.isTurn());
    }

    public String toString() {
        StringBuilder retString = new StringBuilder()
        .append("Game Board:\n")
        .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*"))) .append("\n" + getBoard().toString())
        .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*"))) .append("\n" + getCurrentPlayer().getTeam().toString() + "\n") .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*"))) .append("\n" + getOpponentPlayer().getTeam().toString() + "\n") .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*"))) .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s (" +
            getCurrentPlayer().getTeam().getTeamColor() + "'s) turn\n");
                return retString.toString();
    }

    public boolean isAWinner() {
        return !(this.playerOne.getTeam().getTeamUnits().size() > 0
            && this.playerTwo.getTeam().getTeamUnits().size() > 0);
    }
    public Player getWinner() {
        return (this.playerOne.getTeam().getTeamUnits().size()
            > this.playerTwo.getTeam().getTeamUnits().size())
            ? this.playerOne : this.playerTwo;
    }
    public boolean isGameEnded() {
        return this.playerOne.getTeam().getTeamUnits().size() == 0
            || this.playerTwo.getTeam().getTeamUnits().size() == 0;
    }
}
