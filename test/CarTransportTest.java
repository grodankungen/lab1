package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import src.CarTransport;

import src.Car;
import src.Volvo240;
import src.Saab95;

import java.util.List;

class CarTransportTest extends GenericCarTest {

    @Override
    protected CarTransport createCar() {
        return new CarTransport(5);
    }

    /**
     * Helper: lowers the ramp, loads provided cars, then raises the ramp again
     */
    void helper_load_some_cars(List<Car> theCars) {

        ((CarTransport) car).lower(45);
        for (Car theCar : theCars) {
            ((CarTransport) car).loadCar(theCar);
        }
        ((CarTransport) car).raise(45);
    }

    @Test
    void loadCar() {
        Volvo240 volvo = new Volvo240();
        for (int i = 0; i < 100_00; i++) {
            volvo.gas(1);
        }

        //load while raising ramp
        helper_load_some_cars(List.of(volvo, new Saab95()));
        int currSize = ((CarTransport) car).getLoadedCars().size();
        int exp1 = 2;
        assertEquals(exp1, currSize);

        // test if loadd Volvo speed is 0
        assertEquals(0, volvo.getCurrentSpeed());

        //attempt loading without lowering ramp
        int prevSize = ((CarTransport) car).getLoadedCars().size();

        //DONT --->((CarTransport) car).lower(45);
        ((CarTransport) car).loadCar(new Volvo240());
        currSize = ((CarTransport) car).getLoadedCars().size();

        assertEquals(prevSize, currSize);


    }

    @Test
    void offloadCar() {
        helper_load_some_cars(List.of(new Volvo240(), new Saab95()));

        //Tests offloading before lowering ramp
        //DONT ---> ((CarTransport) car).lower(45);
        ((CarTransport) car).offloadCar();
        int currSize = ((CarTransport) car).getLoadedCars().size();
        int exp1 = 2;
        assertEquals(exp1, currSize);

        //Test offloading after lowering
        ((CarTransport) car).lower(45);
        ((CarTransport) car).offloadCar();
        currSize = ((CarTransport) car).getLoadedCars().size();
        int exp2 = 1;
        assertEquals(exp2, currSize);
    }

    @Test
    public void testOffloadingInRightOrder() {
        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();

        //Volvo is loaded first, then saab95.
        helper_load_some_cars(List.of(volvo, saab95));

        ((CarTransport) car).offloadCar();

        // Check the type of the remaining car is the volvo
        Car c = ((CarTransport) car).getLoadedCars().getFirst();

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
        ((CarTransport) car).lower(45);
        ((CarTransport) car).offloadCar();
        ((CarTransport) car).raise(45);
        car.move();

        assertEquals(currX, volvo.getX());
        assertEquals(currYMcFlurry, volvo.getY());


    }
}
