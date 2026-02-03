package src;

import java.awt.*;

abstract class Truck extends Car implements Cargo {
    private double cargoAngle;

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
    }

    @Override
    abstract protected double speedFactor();

    @Override
    public double getCargoAngle() {
        return this.cargoAngle;
    }

    @Override
    public void raise(double amount) {
        if (getCurrentSpeed() == 0) {
            this.cargoAngle += amount;
            if (this.cargoAngle > 70) {
                this.cargoAngle = 70;
            }
        }
    }

    @Override
    public void lower(double amount) {
        if (getCurrentSpeed() == 0) {
            this.cargoAngle -= amount;
            if (this.cargoAngle < 0) {
                this.cargoAngle = 0;
            }
        }
    }

    @Override
    public void gas(double amount) {
        if (this.cargoAngle == 0) {
            super.gas(amount);
        }
    }

    @Override
    public void brake(double amount) {
        if (this.cargoAngle == 0) {
            super.brake(amount);
        }
    }
}

