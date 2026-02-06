package test;

import org.junit.jupiter.api.Test;
import src.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class CarWorkshopTest {

    @Test
    public void testLoadingWrongVehicle() {
        CarWorkshop<Scania> scaniaWorkshop = new CarWorkshop<>(3);

        //We expect this lambda func to crash, indicating we couldn't load
        //  an incompatible vehicle.
        //NOTE: doesn't test the actual code, but makes sure that
        //  this behavior exists.
        assertThrows(ClassCastException.class, () -> {
            Car fakeCar = new Volvo240();
            // scaniaWorkshop.loadCar(fakeCar); //<-- this wont compile
            scaniaWorkshop.loadCar((Scania) fakeCar); //<-- this will crash
        });
    }

    @Test
    public void testOverloadingWorkshop() {
        CarWorkshop<Car> carWorkshop = new CarWorkshop<>(5);
        for (int i = 0; i < 10; i++) {
            carWorkshop.loadCar(new Volvo240());
        }

        assertEquals(5, carWorkshop.getAmountOfLoadedCars());
    }

    @Test
    public void testOffloadingEmptyWorkshop() {
        CarWorkshop<Car> carWorkshop = new CarWorkshop<>(5);
        carWorkshop.offloadCar(new Volvo240());
        assertEquals(0, carWorkshop.getAmountOfLoadedCars());
    }

    @Test
    public void testOffloadingWrongVehicle() {
        CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<>(5);
        volvoWorkshop.loadCar(new Volvo240());

        //NOTE: the cast blow is expected to throw an exception.
        //  that exception is more part of the language itself, however,
        //  we assert that the code either crashes or won't compile.
        assertThrows(ClassCastException.class, () -> {
            Car fakeCar = new Scania();
            //volvoWorkshop.offloadCar(fakeCar); // <-- this wont compile
            volvoWorkshop.offloadCar((Volvo240) fakeCar); // <-- this always throws an error
        });
    }
}
