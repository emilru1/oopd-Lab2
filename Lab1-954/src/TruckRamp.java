import java.util.ArrayList;

public interface TruckRamp {
    void setRampDown();
    void setRampUp();
    short startLoadMode();
    void exitLoadMode();
    void loadCar(PersonalCar personalCar);
    void unloadCar();
    ArrayList<String> getLoadedCars();
}
