package src;

import com.sun.jdi.connect.Transport;

import java.awt.*;

public class CarFactory {
    public static Car createCar(CarType carType) {

        return createCarWithStartingPosition(carType, new Point(0, 0));
    }

    public static Car createCarWithStartingPosition(CarType carType, Point p) {
        int x = p.x;
        int y = p.y;
        return switch (carType) {
            case VOLVO240 -> new Volvo240(x, y);
            case SAAB95 -> new Saab95(x, y);
            case SCANIA -> new Scania(x, y);
            default -> throw new IllegalArgumentException("Invalid car type");
        };
    }
}
