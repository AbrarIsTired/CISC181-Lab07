/**
 * Represents a Player in our game.
 */
public class Player {
	private int playerNumber;
	private boolean turn;
	private Team team;

	/**
	 * Constructor for creating a new Player object with the player's number,
	 * whether or not it's their turn, and the team they're playing with.
	 * @param playerNumber The player's number.
	 * @param turn If it's the player's current turn.
	 * @param team The team/character the player is playing with.
	 */
	Player(int playerNumber, boolean turn, Team team) {
		this.playerNumber = playerNumber;
		this.turn = turn;
		this.team = team;
	}

	/**
	 * Constructor for creating a new Player object with the player's number,
	 * and the team they're playing with. The turn defaults to false.
	 * @param playerNumber The player's number.
	 * @param team The team/character the player is playing with.
	 */
	Player(int playerNumber, Team team) {
		this.playerNumber = playerNumber;
		this.turn = false;
		this.team = team;
	}

	/**
	 * Constructor for creating a new Player object with default parameters for
	 * whether or not it's their turn, and the team they're playing with.
	 * The player number defaults to 1, if it's their current turn defaults to false,
	 * and the team defaults to Team.
	 */
	Player() {
		this.playerNumber = 1;
		this.turn = true;
		this.team = new Team("Red", null);
	}

	/**
	 * Gets the player's number.
	 * @return The player's number.
	 */
	public int getPlayerNumber() {
		return this.playerNumber;
	}

	/**
	 * Sets the player's number. 
	 * @param playerNumber The player's number.
	 */
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	/**
	 * Returns if it's the player's current turn.
	 * @return if current turn.
	 */
	public boolean isTurn() {
		return this.turn;
	}

	/**
	 * Sets if current turn
	 * @param turn boolean if current turn
	 */
	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	/**
	 * Gets the character/team the player is playing with.
	 * @return The player's character/team.
	 */
	public Team getTeam() {
		return this.team;
	}

	/**
	 * Sets the character/team the player is playing.
	 * @param team The player's character/team to set.
	 */
	public void setPlayersTeam(Team team) {
		this.team = team;
	}
}
