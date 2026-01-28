import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240", 0, new Vector2(1, 0));
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    public void gas(double amount){
        this.incrementSpeed(amount);
    }

    public void brake(double amount){
        this.decrementSpeed(amount);
    }
}
