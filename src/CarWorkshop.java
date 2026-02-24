package src;

import java.awt.*;
import java.util.ArrayList;

public class CarWorkshop<T extends Car> implements HasCarStorage<T> {
    private CarStorage<T> carStorage;
    private final Point point;

    public CarWorkshop(int capacity, Point position) {
        carStorage = new CarStorage<>(capacity);
        this.point = position;
    }

    public void loadCar(T car) {
        carStorage.loadCar(car);
        car.stopEngine();
    }

    public T offloadCar(T car) {
        if (carStorage.getLoadedCars().isEmpty()) {
            System.out.println("The workshop is empty.");
            return null;
        }
        carStorage.offloadCar(car);
        return car;
    }

    public ArrayList<T> getLoadedCars() {
        return new ArrayList<>(carStorage.getLoadedCars());
    }

    public int getX() {
        return point.x;
    }

    public int getY() {
        return point.y;
    }
}
