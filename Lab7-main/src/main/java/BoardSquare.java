/**
 * This class represents every space on our board along with it's color.
 * We keep track of if a space is empty based on whether it contains a unit.
 */

class BoardSquare {
    boolean isEmpty = true;
    Unit unit;
    String color;

    BoardSquare(String color) {
        this.color = color;
    }

    Unit getUnit() {
        return this.unit;
    }

    boolean isEmpty() {
        return this.isEmpty;
    }

    String getSquareColor() {
        return this.color;
    }

    void setUnit(Unit replacement) {
        this.unit = replacement;
        this.isEmpty = false;
    }

    Unit removeUnit() {
        Unit removed = this.unit;
        this.unit = null;
        this.isEmpty = true;
        return removed;
    }

    public String toString() {
        if (this.unit == null) return "-------";
        return "-" + unit.toString() + "-";
    }
}