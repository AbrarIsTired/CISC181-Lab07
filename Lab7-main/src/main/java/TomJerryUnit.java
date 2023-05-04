/**
 * This class is for our Tom & Jerry game piece.
 * Tom can attack using a homing rocket and Jerry uses his strategic skills
 * to gain temporary immunity for cheese and invisibility through hiding.
 */

public class TomJerryUnit extends Attacker {
	private boolean homingRocket;
	private boolean offerCheese;
	private boolean hiding;

	public TomJerryUnit(char symbol, String name, double health, double healthModifier,
		double damage, double damageModifier, int luck, int xCor, int yCor, int movement,
		int movementModifier, boolean homingRocket, boolean offerCheese, boolean hiding) {
		super(symbol, name, health, healthModifier, damage, damageModifier,
			luck, xCor, yCor, movement, movementModifier);
		this.homingRocket = homingRocket;
		this.offerCheese = offerCheese;
		this.hiding = hiding;
	}

	public TomJerryUnit() {
		this(
			'T',
			"Tom & Jerry",
			100.0,
			0.0,
			25.0,
			0.0,
			0,
			5,
			5,
			1,
			0,
			true,
			true,
			false
		);
	}

	public TomJerryUnit spawn() {
		return new TomJerryUnit();
	}
	public boolean canSpawn() {
		return true;
	}
	public boolean canHomingRocket() {
		return this.homingRocket;
	}
	public boolean canOfferCheese() {
		return this.offerCheese;
	}
	public boolean isHiding() {
		return this.hiding;
	}
	public void setHomingRocket(boolean homingRocket) {
		this.homingRocket = homingRocket;
	}
	public void setOfferCheese(boolean offerCheese) {
		this.offerCheese = offerCheese;
	}
	public void setHiding(boolean hiding) {
		this.hiding = hiding;
	}
	
	/**
	 * Calculates damage that will be dealt by the piece
	 *
	 * @return Total damage dealt
	 */
	public double dealDamage() {
		double totalDamage = this.damage + damageModifier;
		if (this.canHomingRocket())
			totalDamage += 10;
		return totalDamage;
	}

	/**
	 * Calculates the result of damage taken.
	 * If the piece is hiding no damage will be taken.
	 *
	 * @param damage the amount of damage that will be taken
	 */
	public void takeDamage(double damage) {
		if (!this.isHiding())
			this.setHealth(this.health - damage);
	}
}