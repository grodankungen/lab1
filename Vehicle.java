import java.awt.*;

abstract class Vehicle extends MovableObject {
    private double currentSpeed;
    private Color color;
    private final String modelName;

    public Vehicle(double currentSpeed, Color color, String modelName) {
        super(0, 0, 0);  // start position (0, 0)
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }

    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public Color getColor() {
        return color;
    }

    protected void setCurrentSpeed(double speed) {
        this.currentSpeed = Math.max(speed, 0);
    }

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);
}
