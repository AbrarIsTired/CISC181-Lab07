import java.util.ArrayList;
public class Controller {
    private Game game;
    private TextView textView;
    public Game setUpGameModel(){
        // Create 4 pieces for team A
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamA = new ArrayList<Unit>();


        BartSimpsonUnit bs = new BartSimpsonUnit();
        bs.setTeamColor("Blu");


        TomJerryUnit tj = new TomJerryUnit();
        tj.setTeamColor("Blu");


        piecesTeamA.add(bs);
        piecesTeamA.add(tj);


        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);
        Player playerOne = new Player(1, true, teamA);


        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamB = new ArrayList<Unit>();


        BartSimpsonUnit bs2 = new BartSimpsonUnit();
        bs2.setTeamColor("Red");


        TomJerryUnit tj2 = new TomJerryUnit();
        tj2.setTeamColor("Red");


        piecesTeamB.add(bs2);
        piecesTeamB.add(tj2);


        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);
        Player playerTwo = new Player(2, false, teamB);


        // Create an instance of the game
        return new Game(8, 8, playerOne, playerTwo);
    }

    public Controller() {
        // Call setUpGameModel and assign its return value to the Game property
        game = setUpGameModel();

        // Create an instance of the TextView class and assign it to the textView property
        textView = new TextView();

        // Call updateView to display the game to our players
        textView.updateView(game);
    }

    public void carryOutAction(int fromRow, int fromCol, int toRow, int toCol, char actionType) {
        Unit unit = game.getBoard().getSquares(fromRow, fromCol).getOccupyingUnit();
        BoardSquare targetSquare = game.getBoard().getSquares(toRow, toCol);

        if (actionType == 'M') {
            if (Rules.checkValidAction(unit, targetSquare)) {
                ActionMove move = new ActionMove(unit, targetSquare);
                move.perfomAction();
            } else {
                System.out.println("Invalid move.");
            }
        } else if (actionType == 'A') {
            if (Rules.checkValidAction(unit, targetSquare)) {
                ActionAttack attack = new ActionAttack(unit, targetSquare);
                attack.perfomAction();
            } else {
                System.out.println("Invalid attack.");
            }
        } else if (actionType == 'R') {
            if (Rules.checkValidAction(unit, targetSquare)) {
                ActionRecruit recruit = new ActionRecruit(unit, targetSquare);
                recruit.perfomAction();
            } else {
                System.out.println("Invalid recruit.");
            }
        } else if (actionType == 'S') {
            if (Rules.checkValidAction(unit, targetSquare)) {
                ActionSpawn spawn = new ActionSpawn(unit, targetSquare);
                spawn.perfomAction();
            } else {
                System.out.println("Invalid spawn.");
            }
        } else {
            System.out.println("Invalid action type.");
        }
    }


    public void playGame() {
        while (!game.isGameEnded()) {
            // Get the next player's action
            Action nextAction = getNextPlayersAction();

            // Check if the action is valid
            while (!Rules.checkValidAction(game, nextAction)) {
                System.out.println("Invalid action. Please try again.");
                nextAction = getNextPlayersAction();
            }

            // Carry out the action
            carryOutAction(nextAction.row(), nextAction.column,
                    nextAction.row(), nextAction.column,
                    nextAction.perfomAction(););

            // Print the game board
            textView.updateView(game);

            // Check if the game has ended
            if (game.isGameEnded()) {
                Player winner = game.getWinner();
                if (winner != null) {
                    System.out.println("Game over! Player " + winner.getPlayerNumber() + " has won!");
                } else {
                    System.out.println("Game over! It's a tie!");
                }
            }
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.playGame();
    }


}
