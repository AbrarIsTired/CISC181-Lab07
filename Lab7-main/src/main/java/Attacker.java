public abstract class Attacker extends Unit {
    private int numAttacks;
    public Attacker(char symbol, String name, double health, double healthModifier,
        double damage, double damageModifier, int luck, int xCor, int yCor,
        int movement, int movementModifier) {
        super(symbol, name, health, healthModifier, damage, damageModifier,
			luck, xCor, yCor, movement, movementModifier);
    }
    public int getNumAttacks() {
        return numAttacks;
    }
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }
    public boolean validAttackPath(int row, int column, int targetRow, int targetColumn) {
        return true;
    }
}
