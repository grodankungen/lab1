package src;

import java.awt.*;

public abstract class Car extends Vehicle {
    private final int nrDoors;
    private final double enginePower;
    private boolean isInCarStorage;

    private final Engine engine;

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int xCord, int yCord) {
        super(currentSpeed, color, modelName, xCord, yCord);

        this.engine = new Engine(enginePower, () -> this.syncSpeed(), () -> this.speedFactor());
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.isInCarStorage = false;
        stopEngine();
    }

    private void syncSpeed() {
        setCurrentSpeed(engine.getEngineSpeed());
    }

    public void startEngine() {
        engine.startEngine();
    }

    public void stopEngine() {
        engine.stopEngine();
    }

    public void gas(double amount) {
        if (!isInCarStorage && amount >= 0 && amount <= 1) {
            engine.gas(amount);
        }
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            engine.brake(amount);
        }
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return engine.getEnginePower();
    }

    @Override
    protected void setCurrentSpeed(double speed) {
        super.setCurrentSpeed(Math.max(0, Math.min(speed, enginePower)));  // in interval [0, enginePower]
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01;
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
