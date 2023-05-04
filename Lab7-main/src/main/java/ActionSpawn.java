
class ActionSpawn extends Action {
    ActionSpawn(Game game, int row, int column, int targetRow, int targetColumn)
        {super(game, row, column, targetRow, targetColumn);}
    void perfomAction() {
        BoardSquare[][] squares = super.game.getBoardSquares();
        BoardSquare square = squares[super.row][super.column];
        BoardSquare target = squares[super.targetRow][super.targetColumn];
        Unit spawn = square.getUnit().spawn(); // ● call the Unit on the ‘from square’s’ spawn method
        super.game.getCurrentPlayer().getTeam().addUnitsToTeam(spawn); // ● add the Unit that was just created to the current team
        target.setUnit(spawn); // ● put Unit that was just created Unit on the board in the ‘to square’
        super.game.changeTurn(); // ● change the turn
    }
}