import java.awt.*;

public class Car extends Vehicle {
    private final int nrDoors;
    private final double enginePower;

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(currentSpeed, color, modelName);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        stopEngine();
    }


    protected void startEngine() {
        setCurrentSpeed(0.1);
    }

    protected void stopEngine() {
        setCurrentSpeed(0);
    }


    // Getters
    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }
}
