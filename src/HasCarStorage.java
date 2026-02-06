package src;

import java.util.ArrayList;

public interface HasCarStorage<T extends Car> {

    public ArrayList<T> getLoadedCars();

    public default int getAmountOfLoadedCars() {
        return getLoadedCars().size();
    }
}
