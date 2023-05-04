/**
 * This class is for our Bart Simpson game piece. Bart moves faster than other
 * pieces,
 * and has the ability to distract and recruit enemies as he passes them.
 */

public class BartSimpsonUnit extends Recruiter {
	final int MAX_NUM_SPAWNED = 1;
	private int numTimesSpawned;
	private boolean distract;
	private boolean recruit;

	public BartSimpsonUnit(
		char symbol, String name, double health, double healthModifier, double damage,
		double damageModifier, int luck, int xCor, int yCor, int movement,
		int movementModifier, int numTimesSpawned, boolean distract, boolean recruit) {
		super(symbol, name, health, healthModifier, damage, damageModifier,
			luck, xCor, yCor, movement, movementModifier);
		this.numTimesSpawned = numTimesSpawned;
		this.distract = distract;
		this.recruit = recruit;
	}
	public BartSimpsonUnit() {
		this('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0,
				5, 5, 1, 0, 0, true, true);
	}

	public int getNumTimesSpawned() {
		return this.numTimesSpawned;
	}
	public void setNumTimesSpawned(int spawned) {
		this.numTimesSpawned = spawned;
	}
	public boolean canDistract() {
		return this.distract;
	}
	public void setDistract(boolean canDistract) {
		this.distract = canDistract;
	}
	public boolean canRecruit() {
		return this.recruit;
	}
	public void setRecruit(boolean canRecruit) {
		this.recruit = canRecruit;
	}

	/**
	 * Determines if a piece can make a copy of itself:
	 * - Only original pieces can make copies: if the symbol is still uppercase
	 * - Number of times spawned is less than the maximum
	 *
	 * @return if the piece can spawn another
	 */

	public boolean canSpawn() {
		return Character.isUpperCase(this.getSymbol())
			&& this.numTimesSpawned < this.MAX_NUM_SPAWNED;
	}

	public void distracted() {
		if (this.distract) System.out.println("Unit Distracted!");
	}

	/**
	 * Creates a copy of the original game piece.
	 * All initial values are the same besides the default spawn location and
	 * symbol.
	 * The symbol is set to a lowercase 'b' to know it's a clone, not an original.
	 * 
	 * @return BartSimpsonUnit with default values
	 */

	public BartSimpsonUnit spawn() {
		BartSimpsonUnit newBart = new BartSimpsonUnit(
			Character.toLowerCase(this.symbol), "Bart Simpson", 100.0, 5.0, 25.0, 10.0, 0, 1,
				1, 1, 1, 0, true, true);
		this.numTimesSpawned++;
		return newBart;
	}
}
