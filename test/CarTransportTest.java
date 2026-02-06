package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import src.CarTransport;

import src.Car;
import src.Volvo240;
import src.Saab95;

import java.util.List;

class CarTransportTest extends GenericCarTest {

    CarTransport car;

    /**
     * Somewhat edited function with unintended sideEffects,
     * however it removes 20+ ((CarTransport) car) casts.
     */
    @Override
    protected CarTransport createCar() {
        car = new CarTransport(5);
        return car;
    }

    /**
     * Helper: lowers the ramp, loads provided cars, then raises the ramp again
     */
    void helper_load_some_cars(List<Car> theCars) {

        car.lower(45);
        for (Car theCar : theCars) {
            car.loadCar(theCar);
        }
        car.raise(45);
    }

    @Test
    void loadCar() {
        Volvo240 volvo = new Volvo240();
        for (int i = 0; i < 100_00; i++) {
            volvo.gas(1);
        }

        //load while raising ramp
        helper_load_some_cars(List.of(volvo, new Saab95()));
        int currSize = car.getAmountOfLoadedCars();
        int exp1 = 2;
        assertEquals(exp1, currSize);

        // test if loadd Volvo speed is 0
        assertEquals(0, volvo.getCurrentSpeed());

        //attempt loading without lowering ramp
        int prevSize = car.getAmountOfLoadedCars();

        //DONT car.lower(45);
        car.loadCar(new Volvo240());
        currSize = car.getAmountOfLoadedCars();

        assertEquals(prevSize, currSize);
    }

    /**
     * Tests that it isn't possible to load a car-transport on another car-transport
     * (we don't support dangerous transport-stacking)
     */
    @Test
    void attemptLoadingUnsupportedCar() {
        helper_load_some_cars(List.of(new CarTransport(10)));

        int exp = 0;
        assertEquals(exp, car.getAmountOfLoadedCars());
    }

    @Test
    void offloadCar() {
        helper_load_some_cars(List.of(new Volvo240(), new Saab95()));

        //Tests offloading before lowering ramp
        //DONT ---> car.lower(45);
        car.offloadCar();
        int currSize = car.getAmountOfLoadedCars();
        int exp1 = 2;
        assertEquals(exp1, currSize);

        //Test offloading after lowering
        car.lower(45);
        car.offloadCar();
        currSize = car.getAmountOfLoadedCars();
        int exp2 = 1;
        assertEquals(exp2, currSize);
    }

    @Test
    public void testOffloadingInRightOrder() {
        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();

        //Volvo is loaded first, then saab95.
        helper_load_some_cars(List.of(volvo, saab95));

        car.offloadCar();

        // Check the type of the remaining car is the volvo
        Car c = car.getLoadedCars().getFirst();

        assertInstanceOf(Volvo240.class, c);

    }

    @Test
    void testMove() {
        Volvo240 volvo = new Volvo240();

        volvo.startEngine();
        volvo.move();

        double prevVolvoX = volvo.getX();
        double prevVolvoY = volvo.getY();

        helper_load_some_cars(List.of(volvo));


        for (int i = 0; i < 100_000; i++) {
            car.gas(1);
        }

        car.move();
        car.turnRight(10);

        car.move();
        car.turnRight(10);

        car.move();
        car.turnRight(10);

        double currX = volvo.getX();
        double currYMcFlurry = volvo.getY();

        // TEST 1(A): assert that volvo has "left" its initial position
        assertNotEquals(prevVolvoX, currX);
        assertNotEquals(prevVolvoY, currYMcFlurry);
        //TEST 1(B): assert that volvo has followed the truck
        assertEquals(car.getX(), currX);
        assertEquals(car.getY(), currYMcFlurry);


        //TEST 2: Tests that the volvo stops "following" once unloaded
        car.stopEngine();
        car.lower(45);
        car.offloadCar();
        car.raise(45);
        car.move();

        assertEquals(currX, volvo.getX());
        assertEquals(currYMcFlurry, volvo.getY());


    }
}
