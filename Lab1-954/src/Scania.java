import java.awt.*;

public abstract class Scania extends Car {

    public double tippingAngle;

    public Scania() {
        super(2, 150,"Scania", Color.white);
    }

    public double getTippingAngle(){
        return tippingAngle;
    }

    public void increaseTipping(double angle){
        tippingAngle = tippingAngle + angle;

    }

    public void decreaseTipping(double angle){
        tippingAngle = tippingAngle - angle;
    }






}

