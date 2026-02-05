package src;

import java.util.ArrayList;

public class CarWorkshop<T extends Car> implements Unloadable {
    private CarStorage<T> carStorage;

    public CarWorkshop(int capacity) {
        carStorage = new CarStorage<>(capacity);
    }

    public void loadCar(T car) {
        carStorage.loadCar(car);
        car.stopEngine();
    }

    public void offloadCar(T car) {
        carStorage.offloadCar(car);
    }

    public ArrayList<T> getLoadedCars() {
        return new ArrayList<>(carStorage.getLoadedCars());
    }
}

