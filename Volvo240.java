import java.awt.*;

public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, 0, Color.black, "Volvo240");
    }

    @Override
    public void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    private double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
