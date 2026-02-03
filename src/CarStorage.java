package src;

import java.util.ArrayList;

public class CarStorage {
    private final int capacity;
    private final ArrayList<Car> loadedCars;

    public CarStorage(int capacity) {
        this.capacity = capacity;
        this.loadedCars = new ArrayList<>();
    }

    public void loadCar(Car car) {
        if (loadedCars.size() < capacity) {
            loadedCars.add(car);
        }
    }

    public void offloadCar() {
        if (loadedCars.isEmpty()) {
            return;
        }
        int index = loadedCars.size() - 1;
        loadedCars.remove(index);
    }

    public void offloadCar(Car car) {
        loadedCars.remove(car);
    }
}
