package src;

import java.awt.*;

public class Volvo240 extends Car implements Transportable {
    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, 0, Color.black, "src.Volvo240");
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
