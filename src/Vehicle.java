package src;

import java.awt.*;

abstract class Vehicle extends MovableObject {
    private final String modelName;
    private Color color;

    public Vehicle(double currentSpeed, Color color, String modelName) {
        super(0, 0, 0, currentSpeed);  // start position (0, 0)
        this.color = color;
        this.modelName = modelName;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }
}
