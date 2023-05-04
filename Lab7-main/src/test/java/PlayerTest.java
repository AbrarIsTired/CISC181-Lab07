import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class PlayerTest {
    @Test
    void ThreeParamPlayer() {
        Team team = new Team("Blue", null);
        Player threeParam = new Player(1, true, team);
        assert(threeParam.isTurn());
        assertEquals(threeParam.getPlayerNumber(), 1);
        assertEquals(threeParam.getTeam(), team);
        assertEquals(threeParam.getTeam().getTeamColor(), "Blue");
        assertEquals(threeParam.getTeam().getTeamUnits(), null);
    }
    @Test
    void TwoParamPlayer() {
        Team team = new Team("Black", null);
        Player twoParam = new Player(1, team);
        assertFalse(twoParam.isTurn());
        assertEquals(twoParam.getPlayerNumber(), 1);
        assertEquals(twoParam.getTeam(), team);
        assertEquals(twoParam.getTeam().getTeamColor(), "Black");
        assertEquals(twoParam.getTeam().getTeamUnits(), null);
    }
    @Test
    void ZeroParamPlayer() {
        Player zeroParam = new Player();
        assert(zeroParam.isTurn());
        assertEquals(zeroParam.getPlayerNumber(), 1);
        assertEquals(zeroParam.getTeam().getTeamColor(), "Red");
        assertEquals(zeroParam.getTeam().getTeamUnits(), null);
    }
    @Test
    void getPlayerNumber() {
        Player playerOne = new Player(1, null);
        Player playerTwo = new Player(2, null);
        assertEquals(playerOne.getPlayerNumber(), 1);
        assertEquals(playerTwo.getPlayerNumber(), 2);
    }
    @Test
    void setPlayerNumber() {
        Player player = new Player(1, null);
        assertEquals(player.getPlayerNumber(), 1);
        player.setPlayerNumber(2);
        assertEquals(player.getPlayerNumber(), 2);
    }
    @Test
    void isTurn() {
        Player playerOne = new Player(1, null);
        Player playerTwo = new Player(2, null);
        playerOne.setTurn(true);
        playerTwo.setTurn(!playerOne.isTurn());
        assertEquals(playerOne.isTurn(), true);
        assertEquals(playerTwo.isTurn(), false);
    }
    @Test
    void setTurn() {
        Player playerOne = new Player();
        playerOne.setTurn(true);
        assertEquals(playerOne.isTurn(), true);
        playerOne.setTurn(false);
        assertEquals(playerOne.isTurn(), false);
    }
    @Test
    void getTeam() {
        ArrayList<Unit> players = new ArrayList<Unit>();
        TomJerryUnit t = new TomJerryUnit();
        BartSimpsonUnit b = new BartSimpsonUnit();
        players.add(t);
        players.add(b);

        Team team = new Team("Black", players);
        Player player = new Player(1, team);
        assertEquals(player.getTeam(), team);
        assertEquals(player.getTeam().getTeamColor(), "Black");
        assertEquals(player.getTeam().getTeamUnits(), players);
    }
    @Test
    void setPlayersTeam() {
        ArrayList<Unit> players = new ArrayList<Unit>();
        TomJerryUnit t = new TomJerryUnit();
        BartSimpsonUnit b = new BartSimpsonUnit();
        players.add(t);
        players.add(b);

        Team team = new Team("Black", players);
        Player player = new Player(1, null);

        assertEquals(player.getTeam(), null);
        player.setPlayersTeam(team);
        assertEquals(player.getTeam().getTeamColor(), "Black");
        assertEquals(player.getTeam().getTeamUnits(), players);
    }
}