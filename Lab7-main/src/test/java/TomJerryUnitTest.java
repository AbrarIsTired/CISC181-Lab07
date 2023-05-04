import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TomJerryUnitTest {

    @Test
    void testSpawn() {
        TomJerryUnit tempTom = new TomJerryUnit();
        assertTrue(tempTom.spawn() instanceof TomJerryUnit);
        assertTrue(tempTom.spawn() instanceof Unit);
    }

    @Test
    void canHomingRocket() {
        TomJerryUnit cannotRocket = new TomJerryUnit('T', "Tom & Jerry", 100.0, 0.0, 
            25.0, 0.0, 0, 5, 5, 1, 0, false, true, false);
        TomJerryUnit canRocket = new TomJerryUnit('T', "Tom & Jerry", 100.0, 0.0, 
            25.0, 0.0, 0, 5, 5, 1, 0, true, true, false);
        assertFalse(cannotRocket.canHomingRocket());
        assertTrue(canRocket.canHomingRocket());
    }

    @Test
    void canOfferCheese() {
        TomJerryUnit cannotCheese = new TomJerryUnit('T', "Tom & Jerry", 100.0, 0.0, 
            25.0, 0.0, 0, 5, 5, 1, 0, true, false, false);
        TomJerryUnit canCheese = new TomJerryUnit('T', "Tom & Jerry", 100.0, 0.0, 
            25.0, 0.0, 0, 5, 5, 1, 0, true, true, false);
        assertFalse(cannotCheese.canOfferCheese());
        assertTrue(canCheese.canOfferCheese());
    }

    @Test
    void isHiding() {
        TomJerryUnit notHidden = new TomJerryUnit('T', "Tom & Jerry", 100.0, 0.0, 
            25.0, 0.0, 0, 5, 5, 1, 0, true, false, false);
        TomJerryUnit hidden = new TomJerryUnit('T', "Tom & Jerry", 100.0, 0.0, 
            25.0, 0.0, 0, 5, 5, 1, 0, true, true, true);
        assertFalse(notHidden.isHiding());
        assertTrue(hidden.isHiding());
    }

    @Test
    void setHomingRocket() {
        TomJerryUnit tempTom = new TomJerryUnit();
        assertTrue(tempTom.canHomingRocket());
        tempTom.setHomingRocket(false);
        assertFalse(tempTom.canHomingRocket());
    }

    @Test
    void setOfferCheese() {
        TomJerryUnit tempTom = new TomJerryUnit();
        assertTrue(tempTom.canOfferCheese());
        tempTom.setOfferCheese(false);
        assertFalse(tempTom.canOfferCheese());
    }

    @Test
    void setHiding() {
        TomJerryUnit tempTom = new TomJerryUnit();
        assertFalse(tempTom.isHiding());
        tempTom.setHiding(true);
        assertTrue(tempTom.isHiding());
    }

    @Test
    void dealDamage() {
        TomJerryUnit tempTom = new TomJerryUnit();
        TomJerryUnit highDamageTom = new TomJerryUnit('T', "Tom & Jerry", 100.0, 0.0, 
            100, 0.0, 0, 5, 5, 1, 0, true, false, false);
        TomJerryUnit noDamageTom = new TomJerryUnit('T', "Tom & Jerry", 100.0, 0.0, 
            0, 0.0, 0, 5, 5, 1, 0, false, false, false);
        assertEquals(tempTom.dealDamage(), 35);
        assertEquals(highDamageTom.dealDamage(), 110);
        assertEquals(noDamageTom.dealDamage(), 0);
    }

    @Test
    void takeDamage() {
        TomJerryUnit notHiding = new TomJerryUnit();
        TomJerryUnit hiding = new TomJerryUnit();
        hiding.setHiding(true);
        assertEquals(notHiding.getHealth(), 100);
        assertEquals(hiding.getHealth(), 100);

        notHiding.takeDamage(0);
        hiding.takeDamage(100);
        assertEquals(notHiding.getHealth(), 100);
        assertEquals(hiding.getHealth(), 100);
    }
}