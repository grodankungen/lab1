package src;

import java.awt.*;

public class CarTransport extends Truck {
    private CarStorage carStorage;

    public CarTransport(int capacity) {
        super(2, 50, 0, Color.white, "The MEGA Car Transport", new RampCargo());
        carStorage = new CarStorage(capacity);
    }

    public void loadCar(Car car) {
        if (car instanceof Loadable && getCargoAngle() == 45) {
            carStorage.loadCar(car);
        }
    }

    public void offloadCar() {
        if (getCargoAngle() != 45) {  // can't offload car if ramp is not lowered
            return;
        }
        carStorage.offloadCar();
    }
}
