import java.awt.*;

abstract class Car extends Vehicle {
    private final int nrDoors;
    private final double enginePower;

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(currentSpeed, color, modelName);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        stopEngine();
    }

    public void startEngine() {
        setCurrentSpeed(0.1);
    }

    public void stopEngine() {
        setCurrentSpeed(0);
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    @Override
    protected void setCurrentSpeed(double speed) {
        super.setCurrentSpeed(Math.max(0, Math.min(speed, enginePower)));  // in interval [0, enginePower]
    }

    private void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    private void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    protected abstract double speedFactor();
}
