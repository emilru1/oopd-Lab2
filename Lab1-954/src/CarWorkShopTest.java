import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarWorkShopTest {

    @Test
    void testBringCar() {
        CarWorkShop<Object> carWorkShop = new CarWorkShop<>(2);
        carWorkShop.bringCar(1);
        carWorkShop.bringCar(2);
        assertEquals(2, carWorkShop.getCarsIn().size());
    }

    @Test
    void testReturnCar() {
        CarWorkShop<Object> carWorkShop = new CarWorkShop<>(2);
        carWorkShop.bringCar("volvo");
        carWorkShop.bringCar("sabb");
        carWorkShop.returnCar();
        carWorkShop.returnCar();
        assertEquals(0,carWorkShop.getCarsIn().size());
    }

    @Test
    void testGetCarsIn() {
        CarWorkShop<Object> carWorkShop = new CarWorkShop<>(2);
        carWorkShop.bringCar("volvo");
        carWorkShop.bringCar("sabb");
        assertEquals(2, carWorkShop.getCarsIn().size());
    }

}