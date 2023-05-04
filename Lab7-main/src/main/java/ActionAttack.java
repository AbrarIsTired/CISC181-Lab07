
class ActionAttack extends Action {
    ActionAttack(Game game, int row, int column, int targetRow, int targetColumn)
        {super(game, row, column, targetRow, targetColumn);}
    void perfomAction() {
        BoardSquare[][] squares = super.game.getBoardSquares();
        BoardSquare square = squares[super.row][super.column];
        BoardSquare target = squares[super.targetRow][super.targetColumn];
        Unit attacker = square.getUnit();
        Unit opponent = target.getUnit();
        if (!(attacker instanceof TomJerryUnit)) return; // ● Attack if the Unit is of type TomJerryUnit (BartSimpsonUnits can only recruit)
        if (opponent instanceof TomJerryUnit) { // for attacking opponent units it should:
            ((TomJerryUnit) opponent).takeDamage(((TomJerryUnit) attacker).dealDamage()); // ● Utilize TomJerryUnit’s dealDamage and takeDamage() methods and
            if (((TomJerryUnit) opponent).getHealth() <= 0) target.removeUnit(); // ● remove an attacked TomJerryUnit if their health is 0 or below.
        } else if (opponent instanceof BartSimpsonUnit) target.removeUnit(); // ● Remove a BartSimpsonUnit if attacked (i.e. health fields are not used - do not use TomJerryUnit’s dealDamage)
        if (target.isEmpty) { // ● Move the Unit on the From Square to the To Square (only if the opponents unit is “dead”)
            square.removeUnit();
            target.setUnit(attacker);
            game.getOpponentPlayer().getTeam().members.remove(opponent); // Hint: two “removes” must occur - one from a square and one from a team - when a unit “dies”.
        }
        super.game.changeTurn(); // ● Change the turn
    }
}