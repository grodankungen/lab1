package test;

import org.junit.jupiter.api.Test;
import src.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class CarWorkshopTest {

    @Test
    public void testLoadingWrongVeicle() {
        CarWorkshop<Scania> scaniaWorkshop = new CarWorkshop<>(3);

        assertThrows(ClassCastException.class, () -> {
            Car fakeCar = new Volvo240();
            scaniaWorkshop.loadCar((Scania) fakeCar);
        });
    }

    @Test
    public void testOverloadingWorkshop() {
        CarWorkshop<Car> carWorkshop = new CarWorkshop<>(5);
        for (int i = 0; i < 10; i++) {
            carWorkshop.loadCar(new Volvo240());
        }
        ArrayList<Car> workshopSize = carWorkshop.getLoadedCars();
        assertEquals(5, workshopSize.size());
    }

    @Test
    public void testOffloadingEmptyWorkshop() {
        CarWorkshop<Car> carWorkshop = new CarWorkshop<>(5);
        carWorkshop.offloadCar(new Volvo240());
        assertEquals(0, carWorkshop.getLoadedCars().size());
    }

    @Test
    public void testOffloadingWrongVeicle() {
        CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<>(5);
        volvoWorkshop.loadCar(new Volvo240());

        assertThrows(ClassCastException.class, () -> {
            Car fakeCar = new Scania();
            volvoWorkshop.offloadCar((Volvo240) fakeCar);
        });
    }
}
