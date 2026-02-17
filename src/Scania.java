package src;

import java.awt.*;

public class Scania extends Truck {
    public Scania() {

        super(2, 80, 0, Color.black, "Scania", new TipCargo(70), 0, 0);
    }

    public Scania(int x, int y) {

        super(2, 80, 0, Color.black, "Scania", new TipCargo(70), x, y);
    }
}