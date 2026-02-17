package src;

import java.awt.*;

public abstract class Car extends Vehicle {
    private final int nrDoors;
    private final double enginePower;
    private boolean isInCarStorage;

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int xCord, int yCord) {
        super(currentSpeed, color, modelName, xCord, yCord);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.isInCarStorage = false;
        stopEngine();
    }

    public void startEngine() {
        if (getCurrentSpeed() == 0) {
            setCurrentSpeed(0.1);
        }
    }

    public void stopEngine() {
        setCurrentSpeed(0);
    }

    public void gas(double amount) {
        if (!isInCarStorage && amount >= 0 && amount <= 1) {
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
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    private void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    protected double speedFactor() {
        return getEnginePower();
    }

    @Override
    protected void setPosition(double x, double y) {
        if (isInCarStorage) {
            super.setPosition(x, y);
        }
    }

    @Override
    public void move() {
        if (!isInCarStorage) {
            super.move();
        }
    }

    public void setCarLoaded() {
        isInCarStorage = true;
    }

    public void setCarOffloaded() {
        isInCarStorage = false;
    }
}
