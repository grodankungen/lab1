package src;

import java.awt.*;

class Scania extends Truck {

    public Scania() {
        super(2, 80, 0, Color.black, "Scania");
    }

    @Override
    protected double speedFactor() {
        return getEnginePower();
    }
}
