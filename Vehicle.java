import java.awt.*;

public class Vehicle implements Movable {
    private double currentSpeed;
    private Color color;
    private final String modelName;

    public Vehicle(double currentSpeed, Color color, String modelName) {
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }

    // Setters
    public void setColor(Color clr) {
        color = clr;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    // Getters
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }


    protected void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + amount);
    }

    protected void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - amount, 0));
    }


    public void move() {

    }

    public void turnLeft() {

    }

    public void turnRight() {

    }
}
