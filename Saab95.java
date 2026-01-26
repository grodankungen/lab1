import java.awt.*;

public class Saab95 extends Car {
    private boolean turboOn;

    public Saab95() {
        super(2, 125, 0, Color.red, "Saab95");
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    public void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    @Override
    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    private double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
