import java.awt.*;

abstract class Vehicle extends MovableObject {
    private final String modelName;
    private double currentSpeed;
    private Color color;

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

    protected void setCurrentSpeed(double speed) {
        this.currentSpeed = Math.max(speed, 0);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }
}
