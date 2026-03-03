package src;

import com.sun.jdi.connect.Transport;

import java.awt.*;

public class CarFactory {
    public static Car createCar(CarType carType, Object... args) {

        return createCarWithStartingPosition(carType, new Point(0, 0), args);
    }

    public static Car createCarWithStartingPosition(CarType carType, Point p, Object... args) {
        int x = p.x;
        int y = p.y;
        return switch (carType) {
            case VOLVO240 -> new Volvo240(x, y);
            case SAAB95 -> new Saab95(x, y);
            case SCANIA -> new Scania(x, y);
            case TRANSPORT -> {

                if (!(args.length == 1 && args[0] instanceof Integer)) {
                    throw new IllegalArgumentException("Invalid args");
                }
                yield new CarTransport((int) args[0], x, y);

            }
            default -> throw new IllegalArgumentException("Invalid car type");
        };
    }
}
