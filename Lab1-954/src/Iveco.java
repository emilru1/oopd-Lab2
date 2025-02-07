import java.awt.*;
import java.util.ArrayList;

public class Iveco extends Vehicle implements TruckRamp{
    protected boolean rampUp;
    protected boolean loadMode;
    protected boolean fairDistance;
    protected ArrayList <String> loadedCars;

    //protected Ramp ramp
    public Iveco() {
        super(2, 130,"Iveco", Color.BLUE);
        this.rampUp = true;
        this.loadMode = false;
        this.fairDistance = true;//  rimlig distans// ce med godsen;
        this.loadedCars = new ArrayList<String>(4);
    }

    public double speedFactor() {

        return enginePower * 0.01;
    }
    @Override
    public void startLoadMode(){
        if (getCurrentSpeed() > 0){
            throw new IllegalArgumentException("Lastbilen står ej stilla.");
        }
        if (this.loadMode) {
            throw new IllegalArgumentException("Lastbilen är redan i LoadMode.");
        }
        this.loadMode = true;
    }
    @Override
    public void exitLoadMode() {
        if (!this.loadMode) {
            throw new IllegalArgumentException("Lastbilen är inte i LoadMode.");
        }
        this.loadMode = false;
    }
    @Override
    public void setRampDown(){
        if (!this.loadMode){
            throw new IllegalArgumentException("Lastbilen är ej i LoadMode.");
        }
        if (!this.rampUp) {
            throw new IllegalArgumentException("Rampen är redan nere.");
        }
        this.rampUp = false;
    }
    @Override
    public void setRampUp(){
        if (!this.loadMode){
            throw new IllegalArgumentException("Lastbilen är ej i LoadMode.");
        }
        if (this.rampUp) {
            throw new IllegalArgumentException("Rampen är redan uppe.");
        }
        this.rampUp = true;
    }
    @Override
    public void loadCar(PersonalCar personalCar){
        if (this.rampUp || !this.loadMode){
            throw new IllegalArgumentException("Lastbilen skall stå still, ha rampen nere och vara i LoadMode.");
        }
        if (!this.fairDistance){
            throw new IllegalArgumentException("Lastbilen är inte på ett rimligt avstånd till rampen.");
        }
        if (this.loadedCars.size() >= 4){
            throw new IllegalArgumentException("Lastbilen kan inte lasta fler än 4 bilar.");

        }
        this.loadedCars.add(personalCar.modelName);

    }
    @Override
    public void unloadCar(){
        if (this.rampUp || !this.loadMode){
            throw new IllegalArgumentException("Lastbilen ska stå stilla, ha rampen nere och vara i LoadMode.");
        }
        if (this.loadedCars.isEmpty()){
            throw new IllegalArgumentException("Lastbilen har ingen bil lastad.");
        }

        this.loadedCars.removeLast();
    }
    @Override
    public ArrayList<String> getLoadedCars() {
        return this.loadedCars;
    }
}
