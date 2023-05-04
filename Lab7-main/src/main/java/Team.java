import java.util.ArrayList;

/**
 * Each player can have many pieces.
 * This class represents all of the pieces controlled by a player, or pieces on the same team.
 */

public class Team {
    String color;
    ArrayList<Unit> members;
    Team(String color, ArrayList<Unit> members) {
        this.color = color;
        this.members = members;
    }
    String getTeamColor() {
        return this.color;
    }
    ArrayList<Unit> getTeamUnits() {
        return this.members;
        // if (this.members != null) return this.members;
        // return new ArrayList<Unit>(0);
    }
    void removeUnitsFromTeam(Unit subtracted) {
        this.members.remove(subtracted);
    }
    void addUnitsToTeam(Unit addition) {
        addition.setTeamColor(this.color);
        this.members.add(addition);
    }

    @Override
    public String toString() {
        String str = this.getTeamColor() + "\n";
        if (members != null)
            for (Unit m : members)
                str += m.toString() + "\n";
        return str;
    }
}
