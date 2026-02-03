package src;

import java.awt.*;

abstract class Truck extends Car implements Cargo {
    private final Cargo cargo;  // Can be either tip or ramp

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Cargo cargo) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        this.cargo = cargo;
    }

    @Override
    public void raise(double amount) {
        if (getCurrentSpeed() == 0) {
            cargo.raise(amount);
        }
    }

    @Override
    public void lower(double amount) {
        if (getCurrentSpeed() == 0) {
            cargo.lower(amount);
        }
    }

    @Override
    public double getCargoAngle() {
        return cargo.getCargoAngle();
    }

    @Override
    public boolean isCargoInResetPosition() {
        return cargo.isCargoInResetPosition();
    }

    @Override
    public void gas(double amount) {
        if (cargo.isCargoInResetPosition()) {
            super.gas(amount);
        }
    }

    @Override
    public void brake(double amount) {
        if (cargo.isCargoInResetPosition()) {
            super.brake(amount);
        }
    }
}

