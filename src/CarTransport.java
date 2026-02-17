package src;

import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Truck implements HasCarStorage<Car> {
    private CarStorage<Car> carStorage;

    public CarTransport(int capacity) {
        super(2, 67, 0, Color.white, "The ULTIMATE Biltransport", new RampCargo(), 0, 0);
        carStorage = new CarStorage<>(capacity);
    }

    public CarTransport(int capacity, int x, int y) {
        super(2, 67, 0, Color.white, "The ULTIMATE Biltransport", new RampCargo(), x, y);
        carStorage = new CarStorage<>(capacity);
    }

    /**
     * Loads given car if it's close enough to the transport and the cargo is lowered.
     * Gives a compile-time warning if a given car doesn't extend the interface Transportable,
     *
     * @param car The car to load
     */
    public <T extends Car & Transportable> void loadCar(T car) {
        double truckX = this.getX();
        double truckY = this.getY();
        double carX = car.getX();
        double carY = car.getY();

        double distance = Math.sqrt(Math.pow(carX - truckX, 2) + Math.pow(carY - truckY, 2));

        if (!isCargoInResetPosition() && distance <= 5) {
            carStorage.loadCar(car);
        } else {
            System.out.println(car + " is not close enough to the ramp.");
        }
    }

    public Car offloadCar() {
        if (!isCargoInResetPosition()) {  // can't offload car if ramp is not lowered
            return carStorage.offloadCar();
        }

        return null;
    }

    public ArrayList<Car> getLoadedCars() {
        return carStorage.getLoadedCars();
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
