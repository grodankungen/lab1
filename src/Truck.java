package src;

import java.awt.*;

abstract class Truck extends Car implements Cargo {
    private double angle;

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower();
    }

    @Override
    public void raise(double amount) {

    }

    @Override
    public void lower(double amount) {

    }
}
