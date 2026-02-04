package src;

import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Truck {
    private CarStorage<Car> carStorage;

    public CarTransport(int capacity) {
        super(2, 67, 0, Color.white, "The ULTIMATE Biltransport", new RampCargo());
        carStorage = new CarStorage<>(capacity);
    }

    public void loadCar(Car car) {
        if (getCargoAngle() == 45) {
            carStorage.loadCar(car);
        }
    }

    public void offloadCar() {
        if (getCargoAngle() != 45) {  // can't offload car if ramp is not lowered
            return;
        }
        carStorage.offloadCar();
    }

    @Override
    public void move() {
        super.move();

        /* The loaded Cars move with a different speed than CarTransport,
        so they must use setPosition() instead of move() */ 
        for (Car car : carStorage.getLoadedCars()) {
            car.setPosition(this.getX(), this.getY());
        }
    }


}
