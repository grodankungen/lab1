package src;

import java.util.ArrayList;

public class CarWorkshop<T extends Car> implements HasCarStorage<T> {
    private CarStorage<T> carStorage;

    public CarWorkshop(int capacity) {
        carStorage = new CarStorage<>(capacity);
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
}
