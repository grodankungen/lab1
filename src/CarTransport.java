package src;

import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Truck {
    private int capacity;
    private RampCargo rampCargo;
    private ArrayList<Car> loadedCars;

    public CarTransport(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, RampCargo rampCargo, int capacity, ArrayList<Car> loadedCars) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, rampCargo);
        this.capacity = capacity;
    }

    public void loadCar(Car car) {
        if (car instanceof PersonalCar && rampCargo.getCargoAngle() == 45 && loadedCars.size() < capacity) {
            loadedCars.add(car);
            capacity++;
        }
    }

    public void offloadCar() {
        if (rampCargo.getCargoAngle() != 45) {  // can't offload car if ramp is not lowered
            return;
        }
        int index = loadedCars.size() - 1;
        loadedCars.remove(index);
    }
}
