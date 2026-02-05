package src;

import java.awt.*;

abstract class Truck extends Car {
    private final Cargo cargo;  // Can be either tip or ramp

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Cargo cargo) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        this.cargo = cargo;
    }

    public void raise(double amount) {
        if (getCurrentSpeed() == 0) {
            cargo.raise(amount);
        }
    }

    public void lower(double amount) {
        if (getCurrentSpeed() == 0) {
            cargo.lower(amount);
        }
    }

    public double getCargoAngle() {
        return cargo.getCargoAngle();
    }

    public boolean isCargoInResetPosition() {
        return cargo.isInResetPosition();
    }

    @Override
    public void gas(double amount) {
        if (cargo.isInResetPosition()) {
            super.gas(amount);
        }
    }

    @Override
    public void brake(double amount) {
        if (cargo.isInResetPosition()) {
            super.brake(amount);
        }
    }
}

