import java.util.Scanner;

public class TextView {
    private int fromSquareRow;
    private int fromSquareCol;
    private int toSquareRow;
    private int toSquareCol;
    private char actionType;

    public int getFromSquareRow() {
        return fromSquareRow;
    }

    public int getFromSquareCol() {
        return fromSquareCol;
    }

    public int getToSquareRow() {
        return toSquareRow;
    }

    public int getToSquareCol() {
        return toSquareCol;
    }

    public char getActionType() {
        return actionType;
    }

    public char getUsersNextActionType() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What action would you like to take? You have Move, Recruit, Attack or Spawn. M, R, A or S: ");
        return scanner.nextLine().charAt(0);
    }

    public int getValidInt(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int input = min - 1;
        while (input < min || input > max) {
            System.out.print(message);
            while (!scanner.hasNextInt()) {
                System.out.print(message);
                scanner.next();
            }
            input = scanner.nextInt();
        }
        return input;
    }


    public void getNextPlayersAction(Game game) {
        actionType = getUsersNextActionType();

        int numRows = game.getBoard().getNumRows();
        int numCols = game.getBoard().getNumColumns();

        fromSquareRow = getValidInt("Enter row for 'fromSquare': ", 0, numRows - 1);
        fromSquareCol = getValidInt("Enter column for 'fromSquare': ", 0, numCols - 1);

        toSquareRow = getValidInt("Enter row for 'toSquare': ", 0, numRows - 1);
        toSquareCol = getValidInt("Enter column for 'toSquare': ", 0, numCols - 1);
    }

    public void updateView(Game game) {
        System.out.println(game);
    }

    public void printEndOfGameMessage(Game game) {
        System.out.println("Game over. " + game.getWinner().getPlayerNumber() + " team won!");
    }
}
