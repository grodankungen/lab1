package src;

import java.awt.*;

abstract class Truck extends Car implements Cargo {
    private double angle;

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
    }

    @Override
    abstract protected double speedFactor();

    @Override
    public void raise(double amount) {
        if (getCurrentSpeed() == 0) {
            this.angle += amount;
            if (this.angle > 70) {
                this.angle = 70;
            }
        }
    }

    @Override
    public void lower(double amount) {
        if (getCurrentSpeed() == 0) {
            this.angle -= amount;
            if (this.angle < 0) {
                this.angle = 0;
            }
        }
    }

    @Override
    public void gas(double amount) {
        if (this.angle == 0) {
            super.gas(amount);
        }
    }

    @Override
    public void brake(double amount) {
        if (this.angle == 0) {
            super.brake(amount);
        }
    }
}

