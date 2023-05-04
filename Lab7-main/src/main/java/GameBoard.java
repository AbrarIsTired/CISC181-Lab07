/**
 * This class takes a row and column length to create a 2D array of squares to hold our pieces.
 */

class GameBoard {
    int numRows;
    int numColumns;
    BoardSquare[][] squares;
    GameBoard(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.setUpEmptyBoard();
    }
    int getNumRows() {
        return numRows;
    }
    int getNumColumns() {
        return numColumns;
    }

    BoardSquare[][] getSquares() {
        return squares;
    }

    /**
	 * Determines if a given row index and column index are inside the bounds of
     * 0 (inclusive) - numRows (exclusive) and 0 (inclusive) - numColumns (exclusive)
     * 
     * @param rowIndex row to check
     * @param columnIndex column to check 
     * @returns boolean if in bounds
	 */
    boolean inBounds(int rowIndex, int columnIndex) {
        return (0 <= rowIndex && rowIndex < this.numRows)
            && (0 <= columnIndex && columnIndex < this.numColumns);
    }

    /**
	 * Creates an empty board using a 2D array of numRows x numColumns
	 */
    private void setUpEmptyBoard() {
        this.squares = new BoardSquare[this.numRows][this.numColumns];
        for (int r = 0; r < this.numRows; r++)
            for (int c = 0; c < this.numColumns; c++)
                this.squares[r][c] = new BoardSquare(c % 2 == 0 ? "black" : "white");
    }

    /**
	 * Loops and randomly selects a tile in the 2D grid, the loop breaks when the tile is empty
     * 
     * @returns an random empty space on the board
	 */
    BoardSquare findRandomEmptySpace() {
        BoardSquare space = null;
        do {
            int randomRow = (int)(Math.random() * (double)this.numRows);
            int randomColumn = (int)(Math.random() * (double)this.numColumns);
            BoardSquare square = this.squares[randomRow][randomColumn];
            if (square.isEmpty()) space = square;
        } while (space == null);
        return space;
    }

    public String toString() {
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");
        for(int col = 0; col < squares[0].length; col++) {
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for (int row = 0; row < squares.length; row++) {
            boardString.append("Row : " + row + "   ");
            for (int col = 0; col < squares[row].length; col++) {
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}