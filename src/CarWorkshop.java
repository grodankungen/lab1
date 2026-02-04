package src;

public class CarWorkshop<T extends Car> {
    private CarStorage<T> carStorage;

    public CarWorkshop(int capacity) {
        carStorage = new CarStorage<>(capacity);
    }

    public void loadCar(T car) {
        carStorage.loadCar(car);
    }

    public void offloadCar(T car) {
        carStorage.offloadCar(car);
    }
}
