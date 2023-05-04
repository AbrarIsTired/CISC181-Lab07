abstract class Action {
    protected Game game;
    protected int row, column;
    protected int targetRow, targetColumn;
    abstract void perfomAction();
    Action(Game game, int row, int column, int targetRow, int targetColumn) {
        this.game = game;
        this.row = row;
        this.column = column;
        this.targetRow = targetRow;
        this.targetColumn = targetColumn;
    }
}