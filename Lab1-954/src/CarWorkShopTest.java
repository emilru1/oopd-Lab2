import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarWorkShopTest {

    @Test
    void testBringCar() {
        CarWorkShop<PersonalCar> carWorkShop = new CarWorkShop<>(2);
        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();
        carWorkShop.bringCar(volvo);
        carWorkShop.bringCar(saab95);
        assertEquals(2, carWorkShop.getCarsIn().size());
    }

    @Test
    void testReturnCar() {
        CarWorkShop<PersonalCar> carWorkShop = new CarWorkShop<>(2);
        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();
        carWorkShop.bringCar(volvo);
        carWorkShop.bringCar(saab95);
        carWorkShop.returnCar();
        carWorkShop.returnCar();
        assertEquals(0,carWorkShop.getCarsIn().size());
    }

    @Test
    void testGetCarsIn() {
        CarWorkShop<PersonalCar> carWorkShop = new CarWorkShop<>(2);
        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();
        carWorkShop.bringCar(volvo);
        carWorkShop.bringCar(saab95);
        assertEquals(2, carWorkShop.getCarsIn().size());
    }

}