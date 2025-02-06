import java.awt.*;
import java.util.ArrayList;

public class Iveco extends Vehicle implements TruckRamp{
    protected boolean rampUp;
    protected boolean isIdle;
    protected boolean fairDistance;
    protected ArrayList <String> loadedCars;

    //protected Ramp ramp
    public Iveco() {
        super(2, 130,"Iveco", Color.BLUE);
        this.rampUp = true;
        this.isIdle = false;
        this.fairDistance = true;//  rimlig distans// ce med godsen;
        this.loadedCars = new ArrayList<String>(4);


    }

    public double speedFactor() {

        return enginePower * 0.01;
    }
    public void setIdle(){
        if (getCurrentSpeed() == 0){
            this.isIdle = true;
        }
    }
    @Override
    public void setRampDown(){
        if (!this.isIdle){
            throw new IllegalArgumentException("Lastbilen står ej stila");
        }
        if (!this.rampUp) {
            throw new IllegalArgumentException("Rampen är redan nere ");
        }
        this.rampUp = false;

    }
    @Override
    public void setRampUp(){
        if (!this.isIdle){
            throw new IllegalArgumentException("Lastbil står ej stila");
        }
        if (this.rampUp) {
            throw new IllegalArgumentException("Rampen är redan uppe ");
        }
        this.rampUp = true;
    }
    @Override
    public void loadCar(PersonalCar personalCar){
        if (this.rampUp || !this.isIdle){
            throw new IllegalArgumentException("Lastbil ska stå stila och rampen ska vara nere ");
        }
        if (!this.fairDistance){
            throw new IllegalArgumentException("bilen är inte på ett rimligt avstånd till rampen ");
        }
        if (loadedCars.size() >= 4){
            throw new IllegalArgumentException("Biltransport kan lasta fler än 4");

        }
        loadedCars.add(personalCar.modelName);

    }
    @Override
    public void unloadCar(PersonalCar personalCar){
        if (this.rampUp || !this.isIdle){
            throw new IllegalArgumentException("Lastbil ska stå stila och rampen ska vara nere ");
        }
        if (this.loadedCars.isEmpty()){
            throw new IllegalArgumentException("Lastbil har ingen lastat bil ");
        }

        this.loadedCars.removeLast();
    }

}
