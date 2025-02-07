import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IvecoTest {

    @Test
    void testStartLoadMode() {
        Iveco iveco = new Iveco();
        iveco.currentSpeed = 1;
        //assertTrue(iveco.loadMode);
        assertThrows(IllegalArgumentException.class, iveco::startLoadMode);
    }

    @Test
    void testExitLoadMode() {
        Iveco iveco = new Iveco();
        iveco.startLoadMode();
        iveco.exitLoadMode();
        assertFalse(iveco.loadMode);
    }

    @Test
    void testSetRampDown() {
        Iveco iveco = new Iveco();
        iveco.startLoadMode();
        iveco.setRampDown();
        assertFalse(iveco.rampUp);
    }

    @Test
    void testSetRampUp() {
        Iveco iveco = new Iveco();
        iveco.startLoadMode();
        iveco.setRampDown();
        assertFalse(iveco.rampUp);
        iveco.setRampUp();
        assertTrue(iveco.rampUp);
    }

    @Test
    void testLoadCar() {
        Iveco iveco = new Iveco();
        Saab95 saab = new Saab95();
        assertTrue(iveco.rampUp);
        iveco.startLoadMode();
        iveco.setRampDown();
        iveco.fairDistance = false;
        assertThrows(IllegalArgumentException.class, () -> iveco.loadCar(saab));
        iveco.fairDistance = true;
        iveco.loadCar(saab);
        assertFalse(iveco.loadedCars.isEmpty());
    }

    @Test
    void testUnloadCar() {
        Iveco iveco = new Iveco();
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        iveco.startLoadMode();
        iveco.setRampDown();
        iveco.fairDistance = true;
        iveco.loadCar(saab);
        iveco.loadCar(volvo);
        iveco.loadCar(saab);
        assertSame(3, iveco.loadedCars.size());
        assertSame("Saab95", iveco.loadedCars.getFirst());
        assertSame("Saab95", iveco.loadedCars.getLast());
        iveco.unloadCar();
        assertSame(2, iveco.loadedCars.size());
        assertSame("Volvo240", iveco.loadedCars.getLast());

    }

    @Test
    void testGetLoadedCars() {
        Iveco iveco = new Iveco();
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        Scania scania = new Scania();

        iveco.startLoadMode();
        iveco.setRampDown();
       // assertThrows(IllegalArgumentException.class, () -> iveco.loadCar(scania));
        iveco.loadCar(volvo);
        iveco.loadCar(saab);
        iveco.loadCar(volvo);
        iveco.loadCar(saab);

        assertThrows(IllegalArgumentException.class, () -> iveco.loadCar(saab));
        assertSame(iveco.getLoadedCars(), iveco.loadedCars);
    }
}
