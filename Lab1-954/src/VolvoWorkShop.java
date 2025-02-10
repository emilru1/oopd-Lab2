import java.util.ArrayList;

public class VolvoWorkShop extends CarWorkShop<Volvo240> {

    public VolvoWorkShop(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public void bringCar(Volvo240 volvo) {
        super.bringCar(volvo);
    }

    @Override
    public void returnCar() {
        super.returnCar();
    }

    @Override
    public ArrayList<Volvo240> getCarsIn() {
        return super.getCarsIn();
        //return new ArrayList<>(carsIn);
    }
}