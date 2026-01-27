import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;

    public Saab95(){
        super(2, Color.red, 125, "Saab95", 0);
	    turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        super.incrementSpeed(speedFactor() * amount);
    }

    public void decrementSpeed(double amount){
        super.decrementSpeed(speedFactor() * amount);
    }
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
