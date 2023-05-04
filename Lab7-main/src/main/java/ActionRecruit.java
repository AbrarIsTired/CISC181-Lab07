
class ActionRecruit extends Action {
    ActionRecruit(Game game, int row, int column, int targetRow, int targetColumn)
        {super(game, row, column, targetRow, targetColumn);}
    void perfomAction() {
        BoardSquare[][] squares = super.game.getBoardSquares();
        BoardSquare target = squares[super.targetRow][super.targetColumn];
        game.getOpponentPlayer().getTeam().members.remove(target.getUnit()); // ● remove the Unit that was recruited from the opponent’s team
        game.getCurrentPlayer().getTeam().members.add(target.getUnit()); // ● add the Unit that was recruited to the current team
        super.game.changeTurn(); // ● change the turn
    }
}