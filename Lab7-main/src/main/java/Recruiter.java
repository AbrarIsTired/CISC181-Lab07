public abstract class Recruiter extends Unit {
    private int numRecruits;
    public Recruiter(char symbol, String name, double health, double healthModifier,
        double damage, double damageModifier, int luck, int xCor, int yCor,
        int movement, int movementModifier) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck,
            xCor, yCor, movement, movementModifier);
    }
    public int getNumRecruits() {
        return numRecruits;
    }
    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }
    public boolean validRecruitPath(int row, int column, int targetRow, int targetColumn) {
        return true;
    }
}
