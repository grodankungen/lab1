package src;

import java.util.ArrayList;

public interface Unloadable<T extends Car> {

    public ArrayList<T> getLoadedCars();

    public default int getAmountOfLoadedCars() {
        return getLoadedCars().size();
    }
}
