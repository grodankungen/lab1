package src;

import java.awt.*;

public class Saab95 extends Car implements Transportable {
    private boolean turboOn;

    public Saab95() {
        super(2, 125, 0, Color.red, "src.Saab95", 0, 0);
        turboOn = false;
    }

    public Saab95(int x, int y) {
        super(2, 125, 0, Color.red, "src.Saab95", x, y);
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
