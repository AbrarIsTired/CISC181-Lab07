/**
 * This class is the base class for a character.
 * All physical characteristics of a character are held here, while subclasses extend a character's traits and abilities.
 */

abstract class Unit {
    protected String teamColor;
    protected char symbol;
    protected String name;
    protected double health;
    protected double healthModifier;
    protected double damage;
    protected double damageModifier;
    protected int luck;
    protected int xCor;
    protected int yCor;
    protected int movement;
    protected int movementModifier;
    Unit(char symbol, String name, double health, double healthModifier,
        double damage, double damageModifier, int luck, int xCor, int yCor,
        int movement, int movementModifier) {
        this.symbol = symbol;
        this.name = name;
        this.health = health;
        this.healthModifier = healthModifier;
        this.damage = damage;
        this.damageModifier = damageModifier;
        this.luck = luck;
        this.xCor = xCor;
        this.yCor = yCor;
        this.movement = movement;
        this.movementModifier = movementModifier;
    }
    Unit(char symbol, String name, double health, double healthModifier,
        double damage, double damageModifier, int luck, int xCor, int yCor,
        int movement, int movementModifier, String teamColor) {
        this(symbol, name, health, healthModifier, damage, damageModifier, luck,
            xCor, yCor, movement, movementModifier);
        this.teamColor = teamColor;
    }

    abstract Unit spawn();
    abstract boolean canSpawn();
    String getTeamColor() {
        return this.teamColor;
    }

    protected char getSymbol() {
        return this.symbol;
    }
    protected String getName() {
        return this.name;
    }
    protected double getHealth() {
        return this.health;
    }
    protected double getHealthModifier() {
        return this.healthModifier;
    }
    protected double getDamage() {
        return this.damage;
    }
    protected double getDamageModifier() {
        return this.damageModifier;
    }
    protected int getLuck() {
        return this.luck;
    }
    protected int getxCor() {
        return this.xCor;
    }
    protected int getyCor() {
        return this.yCor;
    }
    protected int getMovement() {
        return this.movement;
    }
    protected int getMovementModifier() {
        return this.movementModifier;
    }
    protected void setTeamColor(String color) {
        this.teamColor = color;
    }
    protected void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    protected void setName(String name) {
        this.name = name;
    }
    protected void setHealth(double health) {
        this.health = health;
    }
    protected void setHealthModifier(double healthModifier) {
        this.healthModifier = healthModifier;
    }
    protected void setDamage(double damage) {
        this.damage = damage;
    }
    protected void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }
    protected void setLuck(int luck) {
        this.luck = luck;
    }
    protected void setxCor(int xCor) {
        this.xCor = xCor;
    }
    protected void setyCor(int yCor) {
        this.yCor = yCor;
    }
    protected void setMovement(int movement) {
        this.movement = movement;
    }
    protected void setMovementModifier(int movementModifier) {
        this.movementModifier = movementModifier;
    }
    public String toString() {
        return this.teamColor + " " + this.symbol;
    }
    public boolean validMovePath(int row, int column, int targetRow, int targetColumn) {
        return true;
    }
    public boolean validSpawnPath(int row, int column, int targetRow, int targetColumn) {
        return true;
    }
}