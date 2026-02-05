package src;

import java.util.ArrayList;

public class CarStorage<T extends Car> implements Unloadable {
    private final int capacity;
    private final ArrayList<T> loadedCars;

    public CarStorage(int capacity) {
        this.capacity = capacity;
        this.loadedCars = new ArrayList<>();
    }

    public void loadCar(T car) {
        if (loadedCars.size() < capacity) {
            loadedCars.add(car);
            car.carIsLoaded();
            car.stopEngine();
        }
    }

    public void offloadCar() {
        if (loadedCars.isEmpty()) {
            return;
        }
        int index = loadedCars.size() - 1;
        T t = loadedCars.remove(index);
        t.carIsOffloaded();
    }

    public void offloadCar(T car) {
        loadedCars.remove(car);
        car.carIsOffloaded();
    }

    public ArrayList<T> getLoadedCars() {
        return new ArrayList<>(loadedCars);
    }
}
