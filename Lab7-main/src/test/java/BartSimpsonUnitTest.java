import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BartSimpsonUnitTest {

    @Test
    void testSpawn() {
        BartSimpsonUnit tempBart = new BartSimpsonUnit();
        assertTrue(tempBart.spawn() instanceof BartSimpsonUnit);
        assertTrue(tempBart.spawn() instanceof Unit);
    }

    @Test
    void getNumTimesSpawned() {
        BartSimpsonUnit noTimes = new BartSimpsonUnit('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0,
			5, 5, 1, 0, 0, true, true);
        BartSimpsonUnit oneTime = new BartSimpsonUnit('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0,
			5, 5, 1, 0, 1, true, true);
        assertEquals(noTimes.getNumTimesSpawned(), 0);
        assertEquals(oneTime.getNumTimesSpawned(), 1);
    }

    @Test
    void canDistract() {
        BartSimpsonUnit canDistract = new BartSimpsonUnit('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0,
			5, 5, 1, 0, 0, true, true);
        BartSimpsonUnit cannotDistract = new BartSimpsonUnit('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0,
			5, 5, 1, 0, 1, false, true);
        assertTrue(canDistract.canDistract());
        assertFalse(cannotDistract.canDistract());
    }

    @Test
    void canRecruit() {
        BartSimpsonUnit canRecruit = new BartSimpsonUnit('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0,
			5, 5, 1, 0, 0, true, true);
        BartSimpsonUnit cannotRecruit = new BartSimpsonUnit('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0,
			5, 5, 1, 0, 1, true, false);
        assertTrue(canRecruit.canRecruit());
        assertFalse(cannotRecruit.canRecruit());
    }

    @Test
    void canSpawn() {
        BartSimpsonUnit canSpawn = new BartSimpsonUnit('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0,
			5, 5, 1, 0, 0, true, true);
        BartSimpsonUnit cannotSpawn = new BartSimpsonUnit('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0,
			5, 5, 1, 0, 1, true, true);
        assertTrue(canSpawn.canSpawn());
        assertFalse(cannotSpawn.canSpawn());
    }

    @Test
    void setDistract() {
        BartSimpsonUnit tempBart = new BartSimpsonUnit();
        assertTrue(tempBart.canDistract());
        tempBart.setDistract(false);
        assertFalse(tempBart.canDistract());
    }

    @Test
    void setRecruit() {
        BartSimpsonUnit tempBart = new BartSimpsonUnit();
        assertTrue(tempBart.canRecruit());
        tempBart.setRecruit(false);
        assertFalse(tempBart.canRecruit());
    }

    @Test
    void setNumTimesSpawned() {
        BartSimpsonUnit noTimes = new BartSimpsonUnit();
        assertEquals(noTimes.getNumTimesSpawned(), 0);
        noTimes.setNumTimesSpawned(1);
        assertEquals(noTimes.getNumTimesSpawned(), 1);
    }
}