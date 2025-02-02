import java.awt.*;
public class Scania extends Car {
    public double tippingAngle;
    private final double maxTippingAngel = 70.0;
    //public final static double trimFactor = 1.50;


    public Scania() {
        super(2, 150,"Scania", Color.white);
    }

    public double getTippingAngle(){
        return tippingAngle;
    }
    public double speedFactor(){

        return enginePower * 0.01;
    }

    public void increaseTipping(double angle){
        if (getCurrentSpeed() != 0){
            throw new IllegalArgumentException("det går inte tippa när man kör");
        }
        tippingAngle = Math.min(tippingAngle + angle, maxTippingAngel );

    }

    public void decreaseTipping(double angle){
        if (getCurrentSpeed() != 0){
            throw new IllegalArgumentException("det går inte tippa när man kör");
        }
        tippingAngle = Math.max(tippingAngle - angle, 0 );
    }

    public void cheakAtngle(double angle) {
        if (angle > maxTippingAngel || angle < 0) {
            throw new IllegalArgumentException("currentSpeed får inte vara i intervall [0, 70,0]");

        }
    }
    @Override
    public void move(){
        if (tippingAngle > 0){
            throw new IllegalArgumentException("lastbilen ska inte kunna köra om flaket är uppfällt.");
        }
        super.move();
    }


}

