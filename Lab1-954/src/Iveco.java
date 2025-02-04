import java.awt.*;
public class Iveco extends Car{
    protected boolean rampUp;
    protected boolean isIdle;
    protected boolean fairDistance;
    public Iveco() {
        super(2, 130,"Iveco", Color.BLUE);
        this.rampUp = true;
        this.isIdle = false;
        this.fairDistance = true; //  rimlig distance med godsen;

    }

    public double speedFactor() {

        return enginePower * 0.01;
    }
    public void setIdle(){
        if (getCurrentSpeed() == 0){
            isIdle = true;
        }
    }
    public void setRampDown(){
        if (!isIdle){
            throw new IllegalArgumentException("Bilen står ej stila");
        }
        if (!rampUp) {
            throw new IllegalArgumentException("Rampen är redan nere ");
        }
        rampUp = false;

    }
    public void setRampUp(){
        if (!isIdle){
            throw new IllegalArgumentException("Bilen står ej stila");
        }
        if (rampUp) {
            throw new IllegalArgumentException("Rampen är redan uppe ");
        }
        rampUp = true;
    }

    public void loadCar(){
        if (rampUp || !isIdle){
            throw new IllegalArgumentException("bilen ska stå stila och rampen ska vara nere ");
        }


    }


}
